package com.chana.beans;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.chana.beans.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	private double price;
	@ManyToOne(targetEntity = User.class,  
		    cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Access(AccessType.PROPERTY)
	@JoinColumn(name="seller_id")
	private User seller;
	private String size;
	private String color;
	private String material;
	private int amount;
	private String picture;
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", seller=" + seller + ", size=" + size + ", color=" + color + ", material="
				+ material + ", amount=" + amount + ", picture=" + picture + "]";
	}






	

}
