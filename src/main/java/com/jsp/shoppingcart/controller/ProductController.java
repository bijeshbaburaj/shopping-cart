package com.jsp.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart.dao.MerchantDao;
import com.jsp.shoppingcart.dao.ProductDao;
import com.jsp.shoppingcart.dto.Merchant;
import com.jsp.shoppingcart.dto.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	MerchantDao mdao;

	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		Product p = new Product();
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("productobj", p);
		mav.setViewName("productform");
		return mav;
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("prodectobj") Product p, HttpSession session ){
		
		Merchant merchant = (Merchant) session.getAttribute("merchantinfo");
		List<Product> product = merchant.getProduct();
		
		if (product.size()>0) {
			product.add(p);
			merchant.setProduct(product);
		}else {
			List<Product> productList = new ArrayList<Product>();
			productList.add(p);
			
			merchant.setProduct(productList);
		}
		
		pdao.saveProduct(p);
		mdao.updateMerchant(merchant);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "product saved successfully ");
		mav.setViewName("merchantoptions");
		
		return mav;
	}
	
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id, HttpSession session) {
		Merchant merchant = (Merchant) session.getAttribute("merchantinfo");
		
		Merchant m = mdao.deleteProductFromMerchant(merchant.getId(), id);
		
		mdao.updateMerchant(m);
		pdao.deleteProductById(id);
		
		session.setAttribute("merchantinfo", m);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewallproduct");
		return mav;
	}
	
	@RequestMapping("/getproducttoupdate")
	public ModelAndView getProductToUpdate(@RequestParam("id") int id) {
		
		Product p = pdao.findProductById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("updateproduct");
		
		return mav;
	}
	
	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(ServletRequest req, HttpSession session) {
		String id = req.getParameter("id");
		String brand = req.getParameter("brand");
		String categpry = req.getParameter("category");
		String model = req.getParameter("model");
		String price = req.getParameter("price");
		String stock = req.getParameter("stock");
		
		Product p = new Product();
		p.setId(Integer.parseInt(id));
		p.setBrand(brand);
		p.setCategory(categpry);
		p.setModel(model);
		p.setPrice(Double.parseDouble(price));
		p.setStock(Integer.parseInt(stock));
		
		pdao.updateProduct(p);
		
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		Merchant merchant = mdao.findMerchantById(m.getId());
		session.setAttribute("merchantinfo", merchant);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewallproduct");
		
		return mav;
	}		
	
	@RequestMapping("/displayallproducts")
	public ModelAndView displayProducts() {
		List<Product> product = pdao.findAllProduct();
		ModelAndView mav =new ModelAndView();
		
		mav.addObject("productslist", product);
		mav.setViewName("viewallproducttocustomer");
		
		return mav;
	}
	
	@RequestMapping("/displayproductbybrand")
	public ModelAndView displayProductByBrand(ServletRequest req) {
		
		String brand = req.getParameter("brand");
		List<Product> products = pdao.findProductByBrand(brand);

		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("viewallproducttocustomer");
		return mav;
	}
	
	@RequestMapping("/displayproductbycategory")
	public ModelAndView displaypProductByCategory(ServletRequest req) {
		
		String category = req.getParameter("category");
		List<Product> products = pdao.findProductByCategory(category);

		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("viewallproducttocustomer");
		return mav;
	}
	
	@RequestMapping("/displayproductbypricerange")
	public ModelAndView displayProductByPriceRange(ServletRequest req) {
		
		String startingprice = req.getParameter("startingprice");
		String endingprice = req.getParameter("endingprice");
		
		List<Product> products = pdao.findProductByPriceRange(Double.parseDouble(startingprice),Double.parseDouble(endingprice));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist", products);
		mav.setViewName("viewallproducttocustomer");
		return mav;
		
	}
}
