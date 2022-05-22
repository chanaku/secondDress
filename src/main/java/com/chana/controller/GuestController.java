package com.chana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chana.beans.ProductList;
import com.chana.beans.User;
import com.chana.exceptions.LoginException;
import com.chana.login.TokenManager;
import com.chana.services.UserService;

@CrossOrigin
@RestController
@RequestMapping("/guest")
public class GuestController {
	@Autowired
	private UserService userService;
	@Autowired
	private com.chana.login.LoginManager  loginManager;
	@Autowired
	private TokenManager tokenManager;
	
	@PostMapping("/register")
	public void registerNewUser( User user) {
		try {
			userService.addUser(user);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// get all products
		@GetMapping("/product")
		public ProductList getAllProducts() {
			return new ProductList(userService.getAllProducts(userService.getUserId()));
		}
	//add get products by category
}
