package com.chana.beans;

import java.util.List;

public class ShipmentList {
	List<Shipment> shipments;

	public ShipmentList(List<Shipment> shipments) {
	
		this.shipments = shipments;
	}

	public ShipmentList() {

	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}
	
	
}
