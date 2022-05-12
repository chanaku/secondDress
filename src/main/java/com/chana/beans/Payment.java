package com.chana.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@OneToOne(mappedBy = "payment")
	private long id;
	@Column(name = "payment_method")
	private String paymentMethod;
	@Column(name = "payment_owner")
	private String paymentOwner;
//	@ManyToMany
	@JoinColumn(name = "user_id")
	private String userId;
	@Column(name = "paypal_account")
	private String paypalAccount;
	private double price;
	@Column(name = "is_complete")
	private boolean isComplete;
	@Column(name = "payment_date")
	private java.sql.Date paymentDate;

	
	public Payment(long id, String paymentMethod, String paymentOwner, String userId, String paypalAccount,
			double price, boolean isComplete, Date paymentDate) {
		super();
		this.id = id;
		this.paymentMethod = paymentMethod;
		this.paymentOwner = paymentOwner;
		this.userId = userId;
		this.paypalAccount = paypalAccount;
		this.price = price;
		this.isComplete = isComplete;
		this.paymentDate = paymentDate;
	}

	public Payment() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentOwner() {
		return paymentOwner;
	}

	public void setPaymentOwner(String paymentOwner) {
		this.paymentOwner = paymentOwner;
	}

	public String getPaypalAccount() {
		return paypalAccount;
	}

	public void setPaypalAccount(String paypalAccount) {
		this.paypalAccount = paypalAccount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public java.sql.Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(java.sql.Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentMethod=" + paymentMethod + ", paymentOwner=" + paymentOwner
				+ ", paypalAccount=" + paypalAccount + ", price=" + price + ", isComplete=" + isComplete
				+ ", paymentDate=" + paymentDate + "]";
	}

}
