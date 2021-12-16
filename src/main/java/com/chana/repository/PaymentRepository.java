package com.chana.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chana.beans.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	Payment findByUserId(long id);
	List<Payment> findBypaymentDateLessThanEqual(Date date);
	List<Payment> findBypaymentDateBetween(Date fromDate, Date toDate);
}
