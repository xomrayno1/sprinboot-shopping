package com.tampro.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.Entity.Product;
import com.tampro.Repository.ProductRepositoryImpl;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;

@Controller
@RequestMapping("/danh-muc")
public class CategoryController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductRepositoryImpl productRepository;
	
	@GetMapping(value="/{id}")
	public String product(ModelMap map,@PathVariable("id") int id) {
		map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
		int size = 0;
		Pageable pageable = PageRequest.of(size, 4);
		Page<Product> listpage = productRepository.findByCategoryid(id,pageable);
		List<Product> list = new ArrayList<>();
		for(Product pro : listpage) {
			Product product = new Product();
			product = pro;
			list.add(product);
		}
		map.addAttribute("idcategory", list.get(0).getCategoryid());
		map.addAttribute("listproduct",list);
		map.addAttribute("totalpage", listpage.getTotalPages());
		return "products";
	}
	@GetMapping(value="/{id}/{size}")
	public String product(ModelMap map,@PathVariable("id") int id,@PathVariable("size") String size) {
		map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
		
		Pageable pageable = PageRequest.of(Integer.parseInt(size)-1, 4);
		Page<Product> listpage = productRepository.findByCategoryid(id,pageable);
		List<Product> list = new ArrayList<>();
		for(Product pro : listpage) {
			Product product = new Product();
			product = pro;
				
			list.add(product);
		}
		map.addAttribute("listproduct",list);
		map.addAttribute("totalpage", listpage.getTotalPages());
		map.addAttribute("idcategory", list.get(0).getCategoryid());

		
		return "products";
	}
}
