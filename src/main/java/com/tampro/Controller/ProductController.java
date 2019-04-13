package com.tampro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tampro.Service.CategoryService;
import com.tampro.Service.MadeByService;
import com.tampro.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	MadeByService madeservice;
	
	@GetMapping(value="/{url}")
	public String single(ModelMap map,@PathVariable("url") String url) {
		System.out.println(url);
		map.addAttribute("product", productService.getProductDTOByUrl(url));
		map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
		map.addAttribute("listMade",madeservice.getAllMade() );
		return "single";
		
	}

}
