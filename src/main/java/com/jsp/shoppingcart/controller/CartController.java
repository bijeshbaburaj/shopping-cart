package com.jsp.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CartDao;
import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dto.Cart;
import com.jsp.shoppingcart.dto.Customer;
import com.jsp.shoppingcart.dto.Item;

@Controller
public class CartController {

	@Autowired
	CartDao dao;
	
	@Autowired
	CustomerDao custdao;
	
	@RequestMapping("/fetchitemsfromcart")
	public ModelAndView fetchItemsFromCart(HttpSession session) {
		Customer c = (Customer) session.getAttribute("customerinfo");
		
		Customer customer = custdao.findCustomerById(c.getId());  //to get the updated cart
		Cart cart = customer.getCart();
		List<Item> items = cart.getItem();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemlist", items);
		mav.addObject("totalprice", cart.getTotalPrice());
		mav.setViewName("displaycartitemstocustomer");
		
		return mav;
	}
	
}
