package com.chana.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chana.beans.Category;
import com.chana.beans.Order;
import com.chana.beans.Payment;
import com.chana.beans.Product;
import com.chana.beans.Shipment;
import com.chana.beans.User;
import com.chana.exceptions.LoginException;
import com.chana.exceptions.ServiceException;
import com.chana.exceptions.productExceptions.AddProductException;
import com.chana.exceptions.productExceptions.DeleteProductException;
import com.chana.exceptions.productExceptions.ProductDoesntExistsException;
import com.chana.exceptions.productExceptions.ProductNameDoesntExistsException;
import com.chana.exceptions.productExceptions.UpdateProductException;
import com.chana.repository.CategoryRepository;
import com.chana.repository.OrderRepository;
import com.chana.repository.PaymentRepository;
import com.chana.repository.ProductRepository;
import com.chana.repository.ShipmentRepository;
import com.chana.repository.UserRepository;

@Service
public class AdminService extends ClientService {
	@Autowired
	public AdminService(CategoryRepository categoryRepository, OrderRepository orderRepository,
			PaymentRepository paymentRepository, ProductRepository productRepository,
			ShipmentRepository shipmentRepository, UserRepository userRepository) {
		super(categoryRepository, orderRepository, paymentRepository, productRepository, shipmentRepository,
				userRepository);
	}

	public boolean login(String email, String password) throws LoginException {
		if (!email.equals("admin@admin.com")) {
			throw new LoginException("error while trying to login. user or password are incorrect");
		}
		if (!password.equals("admin")) {
			throw new LoginException("error while trying to login. user or password are incorrect");
		}
		return (email.equals("admin@admin.com") && password.equals("admin"));

	}

	public void addProduct(Product product) throws AddProductException {
		if (productRepository.existsByTitle(product.getTitle())) {
			throw new AddProductException("can't add the product, product title already exits.");
		}
		if (product.getPrice() < 0) {
			throw new AddProductException("price must be more then 0.");
		} else {
			productRepository.saveAndFlush(product);
		}
	}

	public void deleteProduct(Long productId) throws DeleteProductException {
		if(productRepository.existsById(productId)) {
		productRepository.deleteById(productId);
		}
		else {
			throw new DeleteProductException("product doesn't exists. con't delete the product.");
		}
	}
	//check if need to add more if's 
	public void updateProduct(Product product) throws UpdateProductException { 
		if(!productRepository.existsById(product.getId())) {
			throw new UpdateProductException("product does't exist");
		}
		if(product.getPrice() < 0) {
			throw new UpdateProductException("price must be more then 0.");
		}
		productRepository.saveAndFlush(product);
	}

	public Product getProductById(Long id) throws ProductDoesntExistsException {
		if(!productRepository.existsById(id)) {
			throw new ProductDoesntExistsException("product does't exist");
		}
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
	public Order getOrderById(long id) {
		return orderRepository.findById(id).orElse(null);
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

	public List<Order> getOrdersByPrice(double price) {
		return orderRepository.findByPrice(price);
	}

	public List<Order> getOrdersByMaxPrice(double max) {
		return orderRepository.findByPriceLessThanEqual(max);
	}

	public List<Order> findOrderByCategory(Category category) {
		return orderRepository.findByCategoryId(category);
	}

	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	public Payment getPaymentById(Long id) {
		return paymentRepository.findById(id).orElse(null);
	}

	public List<Payment> getPaymentByCustomerId(Long id) {
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

	public List<Shipment> getShipmentBySellerId(Long sellerId) {
		return shipmentRepository.findBySellerId(sellerId);
	}

	public List<Shipment> getShipmentByBuyerId(Long buyerId) {
		return shipmentRepository.findByBuyerId(buyerId);
	}

	public Shipment findByTrackingNumber(String track) {
		return shipmentRepository.findByTrackingNumber(track);
	}

	public List<Shipment> getShipmentByArriveDate(Date arriveDate) {
		return shipmentRepository.findByArriveDate(arriveDate);
	}

	public List<Shipment> getShipmentByShipmentDate(Date shipmentDate) {
		return shipmentRepository.findByShipmentDate(shipmentDate);
	}

	public List<Shipment> getShipmentByShipmentCompany(String shipmentCompany) {
		return shipmentRepository.findByShipmentCompany(shipmentCompany);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public void addUser(User user) {
		userRepository.saveAndFlush(user);
	}

	public void updateUser(User user) {
		userRepository.saveAndFlush(user);
	}

	public void deleteUser(long userId) {
		userRepository.deleteById(userId);
	}

	public List<User> getUserByName(String name) {
		return userRepository.findByFirstNameOrLastName(name);
	}

	public List<User> getUserByEmail(String email) {
		return userRepository.findByEmaill(email);
	}

}
