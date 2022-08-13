package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/home")
	public String viewHomePage(Model model) {
		List<Product> list = service.listAll();
		model.addAttribute("listProducts", list);
		return "index";
	}
	
	@RequestMapping(value = "/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product",  product);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}
	
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		service.delete(id);
	return "redirect:/home";	
	}
}
