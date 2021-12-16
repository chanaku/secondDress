package com.chana.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToMany(mappedBy = "product")
	private long id;
	@Column
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	private double price;
	@ManyToMany
	@JoinColumn(name="seller_user_id")
	private User seller;
	private String size;
	private String color;
	private String material;

	public Product(long id, String title, String description, Category category, double price, User seller, String size,
			String color, String material) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
		this.seller = seller;
		this.size = size;
		this.color = color;
		this.material = material;
	}

	public Product() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", price=" + price + ", seller=" + seller + ", size=" + size + ", color=" + color + ", material="
				+ material + "]";
	}

}
