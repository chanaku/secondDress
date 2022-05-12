package com.chana.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chana.beans.Order;
import com.chana.beans.OrderList;
import com.chana.beans.Payment;
import com.chana.beans.Product;
import com.chana.beans.ProductList;
import com.chana.beans.Shipment;
import com.chana.beans.User;
import com.chana.exceptions.LoginException;
import com.chana.exceptions.productExceptions.DeleteProductException;
import com.chana.exceptions.productExceptions.PurchaseProductException;
import com.chana.exceptions.productExceptions.UpdateProductException;

import com.chana.login.LoginRequest;
import com.chana.login.TokenManager;
import com.chana.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private com.chana.login.LoginManager  loginManager;
	@Autowired
	private TokenManager tokenManager;
	
	@PostMapping("/register")
	public void registerNewUser(@RequestBody User user) {
		try {
			userService.addUser(user);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) throws LoginException {
		loginManager.login(loginRequest.getEmail(), loginRequest.getPassword(), loginRequest.getClientType());
		String token = tokenManager.generageToken(loginRequest.getClientType()).toString();
		
		 return new ResponseEntity<>(token,HttpStatus.ACCEPTED);
	}
	
	// add product
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		userService.addProduct(product);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	// delete product
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable("id") long id) {
		try {
			userService.deleteProduct(id);
		} catch (DeleteProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// update product
	@PutMapping("/product")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		try {
			userService.updateProduct(product);
		} catch (UpdateProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// get all products
	@GetMapping("/product")
	public ProductList getAllProducts() {
		return new ProductList(userService.getAllProducts(userService.getUserId()));
	}

	public ResponseEntity<?> purchaseProduct(@RequestBody long userId, @RequestBody Product product) {

		try {
			userService.purchaseProduct(userId, product);
		} catch (PurchaseProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") long id) {
		userService.deleteOrder(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// update order
	@PutMapping("/order")
	public ResponseEntity<?> updateOrder(@RequestBody Order order) {
		userService.updateOrder(order);

		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// get all orders
	@GetMapping("/order")
	public OrderList getAllOrders() {
		return new OrderList(userService.getAllOrdersByUserId(userService.getUserId()));
	}

	// get order by id
	@GetMapping("/order/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable("id") long id) {
		return new ResponseEntity(userService.getOneOrder(id), HttpStatus.ACCEPTED);
	}

	// add payment
	@PostMapping("/payment")
	public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
		userService.addPayment(payment);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	// delete payment
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<?> deletePaymentById(@PathVariable("id") long id) {
		userService.deletePayment(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// update payment
	@PutMapping("/payment")
	public ResponseEntity<?> updatePayment(@RequestBody Payment payment) {
		userService.updatePayment(payment);

		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	// get payment by id
	@GetMapping("/payment/{id}")
	public ResponseEntity<?> getPaymentById(@PathVariable("id") long id) {
		return new ResponseEntity(userService.getPaymentById(id), HttpStatus.ACCEPTED);
	}

	// add shipment
	@PostMapping("/shipment")
	public ResponseEntity<?> addShipment(@RequestBody Shipment shipment) {
		userService.addShipment(shipment);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	// delete shipment
	@DeleteMapping("/shipment/{id}")
	public ResponseEntity<?> deleteShipmentById(@PathVariable("id") long id) {
		userService.deleteShipment(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// update shipment
	@PutMapping("/shipment")
	public ResponseEntity<?> updateShipment(@RequestBody Shipment shipment) {
		userService.updateShipment(shipment);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	// get shipment by id
	@GetMapping("/shipment/{id}")
	public ResponseEntity<?> getShipmentById(@PathVariable("id") long id) {
		return new ResponseEntity(userService.getOneShipmentById(id), HttpStatus.ACCEPTED);
	}
	
	//get all orders by user id
	@GetMapping("/Order/all/{id}")
	public OrderList getAllOrdersById(@PathVariable("id") long id) {
		return new OrderList(userService.getAllOrdersByUserId(id));
	}
}
