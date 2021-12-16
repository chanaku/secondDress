package com.chana.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chana.beans.Order;
import com.chana.beans.Payment;
import com.chana.beans.Product;
import com.chana.beans.Shipment;
import com.chana.repository.CategoryRepository;
import com.chana.repository.OrderRepository;
import com.chana.repository.PaymentRepository;
import com.chana.repository.ProductRepository;
import com.chana.repository.ShipmentRepository;

@Service
public class AdminService extends ClientService {
	@Autowired
	public AdminService(CategoryRepository categoryRepository, OrderRepository orderRepository,
			PaymentRepository paymentRepository, ProductRepository productRepository,
			ShipmentRepository shipmentRepository) {
		super(categoryRepository, orderRepository, paymentRepository, productRepository, shipmentRepository);
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

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getAllProductsByName(String name) {
		return productRepository.findByName(name);
	}

	public List<Product> getAllProductsByCustomerId(Long id) {
		return productRepository.getAllProductsByCustomerId(id);
	}
	public List<Product> getAllProductsByCustomerName(String firstName, String LastName) {
		return productRepository.findBySellerFirstNameOrSellerLastName(firstName, LastName);
	}

	public void addOrder(Order order) {
		orderRepository.save(order);
	}

	public void deleteOrder(Long orderId) {
		orderRepository.deleteById(orderId);
	}

	public void updateOrder(Order order) {
		orderRepository.save(order);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public List<Order> getOrdersByBuyerId(Long id) {
		return orderRepository.findByBuyerId(id);
	}

	public List<Order> getOrdersBySellerId(Long id) {
		return orderRepository.findBySellerId(id);
	}

	public List<Order> getOrdersByDate(Date date) {
		return orderRepository.findByOrderDate(date);
	}

	public List<Order> getOrdersByDateBetweenTwoDates(Date start, Date end) {
		return orderRepository.findByOrderDateBetween(start, end);
	}

	public List<Order> getOrdersByPrice(int price) {
		return orderRepository.findByPrice(price);
	}

	public List<Order> getOrdersByMaxPrice(int price) {
		return orderRepository.findByPriceLessThanEqual(price);
	}

	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	public Payment getPaymentById(Long id) {
		return paymentRepository.findById(id).orElse(null);
	}

	public Payment getPaymentByCustomerId(Long id) {
		return paymentRepository.findByUserId(id);
	}

	public List<Payment> getPaymentsByEndDate(Date endDate) {
		return paymentRepository.findBypaymentDateLessThanEqual(endDate);
	}

	public List<Payment> getPaymentsBetweenTwoDates(Date startDate, Date endDate) {
		return paymentRepository.findBypaymentDateBetween(startDate, endDate);
	}
	public List<Shipment> getAllShipments() {
		return shipmentRepository.findAll();
	}
	public Shipment getShipmentById(Long id) {
		return shipmentRepository.findById(id).orElse(null);
	}
}
