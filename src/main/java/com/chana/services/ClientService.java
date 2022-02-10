package com.chana.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chana.exceptions.LoginException;
import com.chana.exceptions.ServiceException;
import com.chana.repository.CategoryRepository;
import com.chana.repository.OrderRepository;
import com.chana.repository.PaymentRepository;
import com.chana.repository.ProductRepository;
import com.chana.repository.ShipmentRepository;
import com.chana.repository.UserRepository;
@Service
public class ClientService {
	CategoryRepository categoryRepository;
	OrderRepository orderRepository;
	PaymentRepository paymentRepository;
	ProductRepository productRepository;
	ShipmentRepository shipmentRepository;
	UserRepository userRepository;
	
	@Autowired
	public ClientService(CategoryRepository categoryRepository, OrderRepository orderRepository,
			PaymentRepository paymentRepository, ProductRepository productRepository,
			ShipmentRepository shipmentRepository,UserRepository userRepository) {
		this.categoryRepository = categoryRepository;
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
		this.productRepository = productRepository;
		this.shipmentRepository = shipmentRepository;
		this.userRepository=userRepository;
	}
	public ClientService() {
	}
	public boolean login(String email, String password) throws LoginException {
		return false; //to do login method
		
	}
	
}
