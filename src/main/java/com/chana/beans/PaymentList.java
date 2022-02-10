package com.chana.beans;

import java.util.List;

public class PaymentList {
	List<Payment> payments;

	public PaymentList(List<Payment> payments) {
		this.payments = payments;
	}

	public PaymentList() {
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
