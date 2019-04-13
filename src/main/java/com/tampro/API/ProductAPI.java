package com.tampro.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.Service.ProductService;

@RestController
public class ProductAPI {
	@Autowired
	ProductService productser;
	
	@GetMapping(value="/quantity-api/{id}")
	public int coutProduct(ModelMap map,@PathVariable("id") int id) {
		return productser.getQuantity(id);
	}

	
}
