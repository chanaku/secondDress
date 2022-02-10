package com.chana.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name= "orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToMany
	@JoinColumn(name="seller_id")
	private User seller;
	@ManyToOne
	@JoinColumn(name="buyer_id")
	private long buyerId;
	@ManyToMany
	@JoinColumn(name = "product_id")
	private Product product;
	@Column(name="total_price")
	private double totalPrice;
	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	@Column(name="is_package_received")
	private boolean isPackageRecieved;
	@Column(name="is_complete")
	private boolean isComplete;
	@Column(name="order_date")
	private Date orderDate;
	@OneToOne
	@JoinColumn(name="shipment_id")
	private Shipment shipment;
	
	
	
	public Order(long id, User seller, long buyerId, Product product, long totalPrice, Payment payment,
			boolean isPackageRecieved, boolean isComplete, Date orderDate, Shipment shipment) {
		this.id = id;
		this.seller = seller;
		this.buyerId = buyerId;
		this.product = product;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.isPackageRecieved = isPackageRecieved;
		this.isComplete = isComplete;
		this.orderDate = orderDate;
		this.shipment = shipment;
	}
	
	public Order(User seller, long buyerId, Product product, double totalPrice, Payment payment, boolean isPackageRecieved,
			boolean isComplete, Date orderDate, Shipment shipment) {
		this.seller = seller;
		this.buyerId = buyerId;
		this.product = product;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.isPackageRecieved = isPackageRecieved;
		this.isComplete = isComplete;
		this.orderDate = orderDate;
		this.shipment = shipment;
	}

	public Order() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public long getBuyer() {
		return buyerId;
	}
	public void setBuyer(User buyer) {
		this.buyerId = buyerId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public boolean isPackageRecieved() {
		return isPackageRecieved;
	}
	public void setPackageRecieved(boolean isPackageRecieved) {
		this.isPackageRecieved = isPackageRecieved;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", seller=" + seller + ", buyer=" + buyerId + ", product=" + product + ", totalPrice="
				+ totalPrice + ", payment=" + payment + ", isPackageRecieved=" + isPackageRecieved + ", isComplete="
				+ isComplete + "]";
	}
	

}
