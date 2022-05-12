package com.chana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chana.beans.AdminUser;

public interface AdminRepository extends JpaRepository<AdminUser, Long>{
	boolean existsByEmailAndPassword(String email, String password);
}
