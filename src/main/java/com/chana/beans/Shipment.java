package com.chana.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Shipment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToOne(mappedBy = "shipment")
	private long id;
	@Column(name="shipment_date")
	private java.sql.Date shipmentDate;
	@Column(name="arrive_date")
	private java.sql.Date arriveDate;
	@Column(name="shipment_company")
	private String shipmentCompany;
	@Column(name="tracking_number")
	private String TrackingNumber;
	@OneToMany
	@JoinColumn(name="seller_user_id")
	private User seller;
	@ManyToOne
	@JoinColumn(name="buyer_user_id")
	private User buyer;
	@Column(name="signed_by")
	private String signedBy;
	public Shipment(long id, Date shipmentDate, Date arriveDate, String shipmentCompany, String trackingNumber,
			User seller, User buyer, String signedBy) {
		this.id = id;
		this.shipmentDate = shipmentDate;
		this.arriveDate = arriveDate;
		this.shipmentCompany = shipmentCompany;
		TrackingNumber = trackingNumber;
		this.seller = seller;
		this.buyer = buyer;
		this.signedBy = signedBy;
	}
	private Shipment() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public java.sql.Date getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(java.sql.Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public java.sql.Date getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(java.sql.Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	public String getShipmentCompany() {
		return shipmentCompany;
	}
	public void setShipmentCompany(String shipmentCompany) {
		this.shipmentCompany = shipmentCompany;
	}
	public String getTrackingNumber() {
		return TrackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		TrackingNumber = trackingNumber;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public String getSignedBy() {
		return signedBy;
	}
	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", shipmentDate=" + shipmentDate + ", arriveDate=" + arriveDate
				+ ", shipmentCompany=" + shipmentCompany + ", TrackingNumber=" + TrackingNumber + ", seller=" + seller
				+ ", buyer=" + buyer + ", signedBy=" + signedBy + "]";
	}
	
}
