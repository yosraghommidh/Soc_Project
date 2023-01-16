package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.userEntity;


public interface dao extends JpaRepository<userEntity, Long> {
	userEntity findByEmail(String email);
	
	@Query("SELECT u FROM Users u WHERE u.id = :id ")
	userEntity finduserById(@Param("id") Long id);
	
	@Query("SELECT u FROM Users u WHERE u.role = :role ")
	List<userEntity> findUserByRole(@Param("role") String role);
	
	@Modifying
	@Query(value = "UPDATE Users u set u.password = :pwd where u.id = :id", nativeQuery = true)
	void changeUserPassword(@Param("pwd") String pwd, @Param("id") Long id);
	
	@Modifying
	@Query(value = "UPDATE Users u set u.email = :mail where u.id = :id", nativeQuery = true)
	void changeUserEmail(@Param("mail") String mail, @Param("id") Long id);
	
}
