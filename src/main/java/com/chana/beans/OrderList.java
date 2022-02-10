package com.chana.beans;

import java.util.List;

public class OrderList {
	List<Order> orders;

	public OrderList(List<Order> orders) {
		this.orders = orders;
	}
	
	public OrderList() {}
	
	public List<Order> getOrders(){
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders=orders;
	}
}
