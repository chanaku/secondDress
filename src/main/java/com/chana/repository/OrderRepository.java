package com.chana.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chana.beans.Category;
import com.chana.beans.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	Order getById(Long orderId);
	List<Order> findAllByBuyerId(Long buyerId);
	List<Order> findByBuyerId(Long buyerId);
	List<Order> findBySellerId(Long sellerId);
	List<Order> findByOrderDate(Date date);
	List<Order> findByOrderDateBetween(Date startDate,Date endDate);
	List<Order> findByTotalPrice(double price);
	List<Order> findByTotalPriceLessThanEqual(double max);
//	List<Order> findByCategoryId(Category category);
}