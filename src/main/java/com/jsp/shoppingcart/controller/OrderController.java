package com.jsp.shoppingcart.controller;

import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dao.OrderDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;
import com.jsp.shoppingcart.dto.Orders;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class OrderController {

	@Autowired
	OrderDao dao;

	@Autowired
	CustomerDao custdao;

	@Autowired
	ProductDao pdao;

	@Autowired
	CartDao cdao;

	@RequestMapping("/addorder")
	public ModelAndView addOrders() {
		Orders o = new Orders();

		ModelAndView mav = new ModelAndView();
		mav.addObject("orderobj", o);
		mav.setViewName("ordersform");

		return mav;
	}

	@RequestMapping("/placeorder")
	public ModelAndView saveOrder(@ModelAttribute("orderobj") Orders o, HttpSession session) {
		Customer c = (Customer) session.getAttribute("customerinfo");
		Customer customer = custdao.findCustomerById(c.getId());
		Cart cart = customer.getCart();

		List<Item> items = cart.getItem();

		List<Item> itemsList = new ArrayList<Item>(); // to add item less than stock

		List<Item> itemWithGreaterQuantity = new ArrayList<Item>();// to add item greater than stock

		for (Item i : items) {
			Product p = pdao.findProductById(i.getP_Id()); // to get stock of the product
			if (i.getQuantity() < p.getStock()) {
				itemsList.add(i);
				p.setStock(p.getStock() - i.getQuantity());

				pdao.updateProduct(p);
			} else {
				itemWithGreaterQuantity.add(i);
			}
		}
		o.setItems(itemsList);
		double totalPriceOfOrder = 0;
		for (Item i : itemsList) {
			totalPriceOfOrder = totalPriceOfOrder + i.getPrice();
		}
		o.setTotalPrice(totalPriceOfOrder);

		cart.setItem(itemWithGreaterQuantity);

		double totalPrice = 0;
		for (Item item : itemWithGreaterQuantity) {
			totalPrice += item.getPrice();
		}
		cart.setTotalPrice(totalPrice);

		List<Orders> orders = customer.getOrder();

		//
		if (orders.size() > 0) {
			orders.add(o);
			customer.setOrder(orders);
		} else {
			List<Orders> orders1 = new ArrayList<Orders>();
			orders1.add(o);
			customer.setOrder(orders1);
		}

		customer.setCart(cart);
		cdao.updateCart(cart);
		dao.saveOrders(o);
		custdao.updateCustomer(customer);

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "order placed successfully");
		mav.addObject("orderdetails", o);
		mav.setViewName("customerbill");

		return mav;

	}
}
