package com.chana.controller;

import java.sql.Date;

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

import com.chana.beans.Category;
import com.chana.beans.Order;
import com.chana.beans.OrderList;
import com.chana.beans.PaymentList;
import com.chana.beans.Product;
import com.chana.beans.ProductList;
import com.chana.beans.ShipmentList;
import com.chana.beans.User;
import com.chana.beans.UserList;
import com.chana.exceptions.LoginException;
import com.chana.exceptions.productExceptions.AddProductException;
import com.chana.exceptions.productExceptions.DeleteProductException;
import com.chana.exceptions.productExceptions.ProductDoesntExistsException;
import com.chana.exceptions.productExceptions.UpdateProductException;
import com.chana.login.LoginManager;
import com.chana.login.LoginRequest;
import com.chana.login.TokenManager;
import com.chana.services.AdminService;
import com.chana.utils.ClientType;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private LoginManager loginManager;
	@Autowired
	private TokenManager tokenManager;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) throws LoginException{
		loginManager.login(loginRequest.getEmail(), loginRequest.getPassword(), ClientType.ADMINISTRATOR);
		String token = tokenManager.generageToken(ClientType.ADMINISTRATOR);
		return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
	}

	
	// add product
	@PostMapping("/product/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		try {
			adminService.addProduct(product);
		} catch (AddProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	// delete product
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable("id") long id) {
		try {
			adminService.deleteProduct(id);
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
			adminService.updateProduct(product);
		} catch (UpdateProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	// get product by id

	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") long id) {
		ResponseEntity<?> response = new ResponseEntity<Product>(null);
		try {
			response = new ResponseEntity<Product>(adminService.getProductById(id), HttpStatus.ACCEPTED);
		} catch (ProductDoesntExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}
	// get all products

	@GetMapping("/product")
	public ProductList getAllProducts() {
		return new ProductList(adminService.getAllProducts());
	}
	// get all products by name

	@GetMapping("/product/{title}")
	public ProductList getAllProductsByTitle(@PathVariable("title") String title) {
		return new ProductList(adminService.getAllProductsByTitle(title));
	}

	// get all products by customer id
	@GetMapping("/product/customer/{id}")
	public ProductList getAllProductssByName(@PathVariable("id") long id) {
		return new ProductList(adminService.getAllProductsByCustomerId(id));
	}

	// get all products by customer name
	@GetMapping("/product/customer/{name}{last}")
	public ProductList getAllProductsByCustomerName(@PathVariable("name") String name,
			@PathVariable("last") String lastName) {
		return new ProductList(adminService.getAllProductsByCustomerName(name, lastName));
	}

	// add order
	@PostMapping("/order")
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
		adminService.addOrder(order);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	// get order by id
	@GetMapping("/order/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable("id") long id) {
		return new ResponseEntity(adminService.getOrderById(id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") long id) {
		adminService.deleteOrder(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// update order
	@PutMapping("/order")
	public ResponseEntity<?> updateOrder(@RequestBody Order order) {
		adminService.updateOrder(order);

		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	// get all orders

	@GetMapping("/order")
	public OrderList getAllOrders() {
		return new OrderList(adminService.getAllOrders());
	}

	// get all orders by buyer id
	@GetMapping("/order/buyer/{id}")
	public OrderList getAllOrdersByBuyerId(@PathVariable("id") long id) {
		return new OrderList(adminService.getOrdersByBuyerId(id));
	}

	// get all orders by seller id
	@GetMapping("/order/seller/{id}")
	public OrderList getAllOrdersBySellerId(@PathVariable("id") long id) {
		return new OrderList(adminService.getOrdersBySellerId(id));
	}

	// get all orders by date
	@GetMapping("/order/all")
	public OrderList getAllOrdersByDate(@RequestBody Date date) {
		return new OrderList(adminService.getOrdersByDate(date));
	}

	// get all orders by 2 dates
	@GetMapping("/order/allByDates")
	public OrderList getAllOrdersByTwoDates(@RequestBody Date firstdate, Date last) {
		return new OrderList(adminService.getOrdersByDateBetweenTwoDates(firstdate, last));
	}

	// get all orders by price
	@GetMapping("/order/allByPrice")
	public OrderList getAllOrdersByPrice(@RequestBody double price) {
		return new OrderList(adminService.getOrdersByPrice(price));
	}

	// get all orders by max price
	@GetMapping("/order/allByMaxPrice")
	public OrderList getAllOrdersByMaxPrice(@RequestBody double max) {
		return new OrderList(adminService.getOrdersByMaxPrice(max));
	}

	// get all orders by category
//	@GetMapping("/order")
//	public OrderList getAllOrdersByCategory(@RequestBody Category category) {
//		return new OrderList(adminService.findOrderByCategory(category));
//	}

	// get all payments
	@GetMapping("/payment/all")
	public PaymentList getAllPyments() {
		return new PaymentList(adminService.getAllPayments());
	}

	// get payment by id
	@GetMapping("/payment/{id}")
	public ResponseEntity<?> getPaymentById(@PathVariable("id") long id) {
		return new ResponseEntity(adminService.getPaymentById(id), HttpStatus.ACCEPTED);
	}

	// get payment by customer id
	@GetMapping("/payment/customer/{id}")
	public PaymentList getPaymentByCustomerId(@PathVariable("id") long id) {
		return new PaymentList(adminService.getPaymentByCustomerId(id));
	}

	// get payment by end date
	@GetMapping("/payment/byDate")
	public PaymentList getPaymentByEndDate(@PathVariable("date") Date date) {
		return new PaymentList(adminService.getPaymentsByEndDate(date));
	}
	
	//delete 

	// get all orders by 2 dates
	@GetMapping("/payment/twoDates")
	public PaymentList getAllPaymentsBetweenTwoDates(@RequestBody Date firstdate, Date last) {
		return new PaymentList(adminService.getPaymentsBetweenTwoDates(firstdate, last));
	}

	// get all shipments
	@GetMapping("/shipment")
	public ShipmentList getAllShipments() {
		return new ShipmentList(adminService.getAllShipments());
	}

	// get shipment by id
	@GetMapping("/shipment/{id}")
	public ResponseEntity<?> getShipmentById(@PathVariable("id") long id) {
		return new ResponseEntity(adminService.getShipmentById(id), HttpStatus.ACCEPTED);
	}

	// get all shipments by seller id
	@GetMapping("/shipment/seller/{id}")
	public ShipmentList getAllShipmentsBySellerId(@PathVariable("id") long id) {
		return new ShipmentList(adminService.getShipmentBySellerId(id));
	}

	// get all shipments by seller id
	@GetMapping("/shipment/buyer/{id}")
	public ShipmentList getAllShipmentsByBuyerId(@PathVariable("id") long id) {
		return new ShipmentList(adminService.getShipmentByBuyerId(id));
	}

	// get shipment by tracking number
	@GetMapping("/shipment/track/{track}")
	public ResponseEntity<?> getShipmentByTrackingNumber(@PathVariable("track") String track) {
		return new ResponseEntity(adminService.findByTrackingNumber(track), HttpStatus.ACCEPTED);
	}

	// get all shipments by arrive date
	@GetMapping("/shipment/allArriveDate")
	public ShipmentList getAllShipmentsArriveDate(@RequestBody Date arrive) {
		return new ShipmentList(adminService.getShipmentByArriveDate(arrive));
	}

	// get all shipments by shipment date
	@GetMapping("/shipment/shipDate")
	public ShipmentList getAllShipmentsByShipmentDate(@RequestBody Date arrive) {
		return new ShipmentList(adminService.getShipmentByShipmentDate(arrive));
	}

	// get all shipments by shipment dacompany
	@GetMapping("/shipment/company")
	public ShipmentList getAllShipmentsByShipmentCompany(@RequestBody String company) {
		return new ShipmentList(adminService.getShipmentByShipmentCompany(company));
	}

	// get all shipments by shipment dacompany
	@GetMapping("/user")
	public UserList getAllUsers() {
		return new UserList(adminService.getAllUsers());
	}

	// get user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
		return new ResponseEntity(adminService.getUserById(id), HttpStatus.ACCEPTED);
	}
	// add user
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user) {
		adminService.addUser(user);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	//delete user
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		adminService.deleteUser(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	// update user
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		adminService.updateUser(user);

		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	// get users by name
	@GetMapping("/user/{name}{last}")
	public UserList getUsersByName(@PathVariable ("name")String name,@PathVariable("last")String last ) {
		return new UserList(adminService.getUserByName(name, last));
	}
	// get users by email
	@GetMapping("/user/{email}")
	public UserList getUsersByEmail(@PathVariable ("email") String email) {
		return new UserList(adminService.getUserByEmail(email));
	}
}
