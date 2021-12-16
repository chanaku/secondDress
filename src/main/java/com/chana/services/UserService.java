package com.chana.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chana.beans.Order;
import com.chana.beans.Payment;
import com.chana.beans.Product;
import com.chana.beans.Shipment;
import com.chana.beans.User;
import com.chana.repository.CategoryRepository;
import com.chana.repository.OrderRepository;
import com.chana.repository.PaymentRepository;
import com.chana.repository.ProductRepository;
import com.chana.repository.ShipmentRepository;
import com.chana.repository.UserRepository;
import com.chana.utils.ServiceException;
@Service
public class UserService extends ClientService{
	
	
	@Autowired
	protected CategoryRepository categoryRepository;
	protected OrderRepository orderRepository;
	protected PaymentRepository paymentRepository;
	protected ProductRepository productRepository;
	protected ShipmentRepository shipmentRepository;
	protected UserRepository userRepository;
	
	long userId;
	
	public UserService(CategoryRepository categoryRepository, OrderRepository orderRepository,
			PaymentRepository paymentRepository, ProductRepository productRepository,
			ShipmentRepository shipmentRepository) {
		super(categoryRepository, orderRepository, paymentRepository, productRepository, shipmentRepository);
		
	}
	public boolean login(String email, String password) throws ServiceException {
		if(userRepository.exitsByEmailAndPassword(email, password)) {
			userId = userRepository.findByEmailAndPassword(email, password).getId();
			return true;
		}
		throw new ServiceException("login failed. email or password are incorrect");
		
	}
	
	public void addProduct(Product product) {
		productRepository.saveAndFlush(product);
	}
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
	public void updateProduct(Product product) {
		productRepository.saveAndFlush(product);
	}
	public List<Product> getAllProducts(Long userId){
		return productRepository.getAllProductsByCustomerId(userId);
	}
	
	public void addOrder(Order order) {
		orderRepository.save(order);
	}
	public Order getOneOrder(Long orderId) {
		return orderRepository.getById(orderId);
	}
	public void deleteOrder(Long orderId) {
		orderRepository.deleteById(orderId);
	}

	public void updateOrder(Order order) {
		orderRepository.save(order);
	}
	public void addPayment(Payment payment) {
		paymentRepository.save(payment);
	}
	public void deletePayment(Long paymentId) {
		paymentRepository.deleteById(paymentId);
	}
	public void updatePayment(Payment payment) {
		paymentRepository.save(payment);
	}
	public void addShipment(Shipment shipment) {
		shipmentRepository.save(shipment);
	}
	public void deleteShipment(Long shipmentId) {
		shipmentRepository.deleteById(shipmentId);
	}
	public void updateShipment(Shipment shipment) {
		shipmentRepository.save(shipment);
	}
	public Shipment getOneShipmentById(Long shipmentId) {
		return shipmentRepository.getById(shipmentId);
	}
	public List<Order> getAllOrdersByUserId(Long userId){
		return orderRepository.findAllByUserId(userId);
	}
}
