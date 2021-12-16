package com.chana.repository;

import org.springframework.stereotype.Repository;

import com.chana.beans.User;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	boolean exitsByEmailAndPassword(String email, String password);
	User findByEmailAndPassword(String email, String password);
}
