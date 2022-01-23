package com.chana.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chana.repository.CategoryRepository;
import com.chana.repository.OrderRepository;
import com.chana.repository.PaymentRepository;
import com.chana.repository.ProductRepository;
import com.chana.repository.ShipmentRepository;
import com.chana.repository.UserRepository;
import com.chana.utils.ServiceException;
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
	public boolean login(String email, String password) throws ServiceException {
		return false; //to do login method
		
	}
	
}
