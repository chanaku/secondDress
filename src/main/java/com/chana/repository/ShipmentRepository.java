package com.chana.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chana.beans.Shipment;
@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long>{
	List<Shipment> findBySellerId(Long id);
	List<Shipment> findByBuyerId(Long buyerId);
	Shipment findByTrackingNumber(String track);
	List<Shipment> findByArriveDate(Date arriveDate);
	List<Shipment> findByShipmentDate(Date shipmentDate);
	List<Shipment> findByShipmentCompany(String shipmentCompany);
}
