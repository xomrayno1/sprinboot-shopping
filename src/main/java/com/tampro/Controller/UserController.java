package com.tampro.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tampro.Model.UserDTO;
import com.tampro.Service.CategoryService;
import com.tampro.Service.ProductService;
import com.tampro.Service.UserService;

@Controller
public class UserController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userSer;
	
	@GetMapping(value="/dang-nhap")
	public String login(ModelMap map) {
		map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
		return "login";
	}
	@GetMapping(value="/dang-ky")
	public String register(ModelMap map) {
		map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
		map.addAttribute("User", new UserDTO());	
		return "register";
	}
	@PostMapping(value="/register")
	public String register(ModelMap map,@Valid @ModelAttribute("User")UserDTO userdto,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
			System.out.println("sinh ra loi trong bindding");
			return  "register";
		}
		boolean kt = userSer.addUserDTO(userdto);
		if(kt==true) { // them thanh cong
			map.addAttribute("listCategory", categoryService.getAllCategoryDTO());
			map.addAttribute("msg", "Thêm Thành Công");
			return "login";
		}
		
		map.addAttribute("msg", "Thêm Thất bại, User Hoặc Email Đã Có Người Sử Dụng");
		return "register";
	}
	
}
