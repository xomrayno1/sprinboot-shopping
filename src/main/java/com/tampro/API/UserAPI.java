package com.tampro.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.Service.UserService;

@RestController
public class UserAPI {
	
	
	@Autowired
	UserService userService;
	
	
	

}
