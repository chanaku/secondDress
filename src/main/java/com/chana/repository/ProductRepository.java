package com.chana.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chana.beans.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Transactional
	@Modifying
	@Query(value = "select * from products where user_id =?1 ", nativeQuery = true)
		List<Product> getAllProductsByCustomerId(Long companyId);
	
	void buyProduct(Long userId, Long productId); //to do
	void sellProduct(Long sellerId, Long productId, Long buyerId); // to do
	
	List<Product> findByName(String name);
	List<Product> findBySellerFirstNameOrSellerLastName(String firstName, String lastName);
}