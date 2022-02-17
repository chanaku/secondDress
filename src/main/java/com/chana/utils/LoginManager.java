package com.chana.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.chana.exceptions.LoginException;
import com.chana.login.TokenManager;
import com.chana.services.AdminService;
import com.chana.services.ClientService;
import com.chana.services.UserService;


@Component
public class LoginManager {
	private final ApplicationContext context;
	private final AdminService adminService;
	private TokenManager tokenManager;
	private ClientService clientService;
	
	@Autowired

	public LoginManager(ApplicationContext context, AdminService adminService, TokenManager tokenManager) {
		this.context = context;
		this.adminService = adminService;
		this.tokenManager = tokenManager;
	}
	public ClientService login(String email, String password, ClientType clientType) throws LoginException{
		switch(clientType) {
		case ADMINISTRATOR:
			clientService=context.getBean(AdminService.class);
			break;
		case USER:
			clientService=context.getBean(UserService.class);
			break;
		}
		if (!clientService.login(email, password)) {
			throw new LoginException(clientType.name().toString() + " Unauthorized");
	}
		return clientService;
	}
	
	public void logout(String token) {
		tokenManager.removeToken(token);
	}
}
