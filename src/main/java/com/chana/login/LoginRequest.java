package com.chana.login;

import org.springframework.beans.factory.annotation.Autowired;

import com.chana.login.LoginRequest.LoginRequestBuilder;
import com.chana.services.AdminService;
import com.chana.utils.ClientType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoginRequest {
	private String email;
	private String password;
	private ClientType clientType;

	

//	public ClientType getClientType() {
//		setClientType();
//		return clientType;
//	}
//
//
//	public void setClientType() {
//		AdminService admin = new AdminService();
//		this.clientType = admin.findClientType(email, password);
//	}

}
