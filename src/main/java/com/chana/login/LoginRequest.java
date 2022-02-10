package com.chana.login;

import com.chana.login.LoginRequest.LoginRequestBuilder;
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

	/**
	 * Contractor without password
	 * 
	 * @param email
	 * @param clientType
	 */

	public LoginRequest(String email, ClientType clientType) {
		this.email = email;
		this.clientType = clientType;
	}

}
