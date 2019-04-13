package com.tampro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	

	@GetMapping(value= {"/","home"})
	public String index(ModelMap map) {
		map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
		map.addAttribute("listProduct",productService.get8ProductByDateNews());	
		return "home";
	}
}
