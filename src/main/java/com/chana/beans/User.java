package com.chana.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ManyToMany(mappedBy = "user")
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String Address;
	private String City;
	private String email;
	@Column(name="user_name")
	private String userName;
	private String password;
	
	public User(long id, String firstName, String lastName, String address, String city, String email, String userName,
			String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Address = address;
		City = city;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	public User() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address
				+ ", City=" + City + ", email=" + email + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
