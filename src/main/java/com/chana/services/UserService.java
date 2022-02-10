package com.chana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chana.beans.Order;
import com.chana.beans.Payment;
import com.chana.beans.Product;
import com.chana.beans.Shipment;
import com.chana.beans.User;
import com.chana.exceptions.LoginException;
import com.chana.exceptions.ServiceException;
import com.chana.exceptions.productExceptions.DeleteProductException;
import com.chana.exceptions.productExceptions.PurchaseProductException;
import com.chana.exceptions.productExceptions.UpdateProductException;
import com.chana.repository.CategoryRepository;
import com.chana.repository.OrderRepository;
import com.chana.repository.PaymentRepository;
import com.chana.repository.ProductRepository;
import com.chana.repository.ShipmentRepository;
import com.chana.repository.UserRepository;

@Service
public class UserService extends ClientService {

	@Autowired
	protected CategoryRepository categoryRepository;
	protected OrderRepository orderRepository;
	protected PaymentRepository paymentRepository;
	protected ProductRepository productRepository;
	protected ShipmentRepository shipmentRepository;
	protected UserRepository userRepository;

	long userId;
	
	public long getUserId() {
		return this.userId;
	}



	public UserService(CategoryRepository categoryRepository, OrderRepository orderRepository,
			PaymentRepository paymentRepository, ProductRepository productRepository,
			ShipmentRepository shipmentRepository, UserRepository userRepository) {
		super(categoryRepository, orderRepository, paymentRepository, productRepository, shipmentRepository,
				userRepository);

	}

	public boolean login(String email, String password) throws LoginException {
		if (userRepository.exitsByEmailAndPassword(email, password)) {
			userId = userRepository.findByEmailAndPassword(email, password).getId();
			return true;
		}
		throw new LoginException("login failed. email or password are incorrect");

	}

    //to do cancel order

	public void addProduct(Product product) {
		productRepository.saveAndFlush(product);
	}

	public void deleteProduct(Long productId) throws DeleteProductException {
		if (productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
		} else {
			throw new DeleteProductException("product doesn't exists.");
		}
	}

	public void updateProduct(Product product) throws UpdateProductException {
		if (!productRepository.existsById(product.getId())) {
			throw new UpdateProductException("product does't exist");
		}
		if (product.getPrice() < 0) {
			throw new UpdateProductException("price must be more then 0.");
		}
		productRepository.saveAndFlush(product);
	}

	public List<Product> getAllProducts(Long userId) {
		return productRepository.getAllProductsByCustomerId(userId);
	}

	public void purchaseProduct(long userId, Product product) throws PurchaseProductException {
		if (productRepository.existsByIdAndAmountEquals(product.getId(), 0)) {
			throw new PurchaseProductException("amount is not enough");
		} else {

			orderRepository.saveAndFlush(new Order(product.getSeller(), userId, product, product.getPrice(), null,
					false, false, null, null));
			productRepository.updateProductQuantity(product.getId());
		}
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
	
	public Payment getPaymentById(long id) {
		return paymentRepository.findById(id).orElse(null);
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

	public List<Order> getAllOrdersByUserId(Long userId) {
		return orderRepository.findAllByUserId(userId);
	}

}
