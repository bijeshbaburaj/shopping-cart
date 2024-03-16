package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dao.ItemDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class ItemController {

	@Autowired
	ItemDao dao;

	@Autowired
	ProductDao pdao;

	@Autowired
	ItemDao idao;

	@Autowired
	CartDao cdao;

	@Autowired
	CustomerDao custdao;

	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id") int id) {

		Product p = pdao.findProductById(id);

		ModelAndView mav = new ModelAndView();

		mav.addObject("productobj", p);
		mav.setViewName("itemform");

		return mav;

	}

	@RequestMapping("/additemtocart")
	public ModelAndView addItemToCart(ServletRequest request, HttpSession session) {
		int pid = Integer.parseInt(request.getParameter("id"));
		String brand = request.getParameter("brand");
		double price = Double.parseDouble(request.getParameter("price"));
		String model = request.getParameter("model");
		String category = request.getParameter("category");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Item item = new Item();
		item.setBrand(brand);
		item.setCategory(category);
		item.setModel(model);
		item.setQuantity(quantity);
		item.setP_Id(pid);
		item.setPrice(price * quantity);

		Customer customer = (Customer) session.getAttribute("customerinfo");
		Cart c = customer.getCart();

		if (c == null) {

			Cart cart = new Cart();

			List<Item> items = new ArrayList<Item>();
			items.add(item);

			cart.setItem(items);
			cart.setName(customer.getName());
			cart.setTotalPrice(price);
			cart.setTotalPrice(item.getPrice());

			customer.setCart(cart);

			dao.saveItem(item);
			
			cdao.saveCart(cart);

			custdao.updateCustomer(customer);
		} else {

			List<Item> items = c.getItem();

			if (items.size() > 0) {
				items.add(item);
				c.setItem(items);
				double totalPrice = 0;

				for (Item i : items) {
					totalPrice = totalPrice + i.getPrice();
				}
				c.setTotalPrice(totalPrice);
				idao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
			} else {
				List<Item> itemsList = new ArrayList<Item>();
				itemsList.add(item);
				c.setItem(itemsList);
				c.setTotalPrice(item.getPrice());

				dao.saveItem(item);
				cdao.updateCart(c);
				custdao.updateCustomer(customer);
			}
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://displayallproducts");

		return mav;

	}
}
