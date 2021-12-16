package com.chana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chana.beans.Shipment;
@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

}
