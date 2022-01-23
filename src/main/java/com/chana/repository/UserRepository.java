package com.chana.repository;

import org.springframework.stereotype.Repository;

import com.chana.beans.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	boolean exitsByEmailAndPassword(String email, String password);
	User findByEmailAndPassword(String email, String password);
	List<User> findByFirstNameOrLastName(String name);
	User findByEmaill(String email);
}
