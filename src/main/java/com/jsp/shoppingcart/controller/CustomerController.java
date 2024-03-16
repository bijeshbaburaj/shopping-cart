package com.jsp.shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.CustomerDao;
import com.jsp.shoppingcart.dto.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao dao;

	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {
		Customer c = new Customer();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("customerobj", c);
		mav.setViewName("customerform");
		
		return mav;
		
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer c) {
		
		dao.saveCustomer(c);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "register saved successfully");
		mav.setViewName("customerloginform");
		
		return mav;
		
	}
	
	@RequestMapping("/customerloginvalidation")
	public ModelAndView login(ServletRequest request, HttpSession session) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer c = dao.login(email, password);
		
		ModelAndView mav = new ModelAndView();
		
		if (c != null) {
			mav.addObject("msg", "welcome ");
			mav.setViewName("customeroptions");
			session.setAttribute("customerinfo", c);
			return mav;
		} else {
			mav.addObject("msg", "invalid credentials");
			mav.setViewName("customerloginform");
			return mav;
		}
	}

}
