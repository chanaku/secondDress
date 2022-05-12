package com.chana.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.chana.beans.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "AdminUser")
public class AdminUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String email;
	String password;
}
