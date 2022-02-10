package com.chana.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.chana.services.AdminService;
import com.chana.services.ClientService;
import com.chana.services.UserService;


@Component
public class LoginManager {
	@Autowired
	private ApplicationContext context;
	public ClientService login(String email, String password, ClientType clientType) {
		ClientService clientService=new ClientService();
		
		switch(clientType) {
		case ADMINISTRATOR:
			clientService=context.getBean(AdminService.class);
		case USER:
			clientService=context.getBean(UserService.class);
		
		}
		return clientService;
	}
}
