package com.example.demo.repository;

import java.util.List;
import 
org.springframework.stereotype.Repository ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.user;
@Repository
public interface repository extends JpaRepository<user, Long> {
	user findByEmail(String email);
	
	/*@Query(value = "SELECT u FROM users u WHERE u.id = :id ")
	user finduserById(@Param("id") Long id);
	

	@Modifying
	@Query(value = "UPDATE users u set u.password = :pwd where u.id = :id", nativeQuery = true)
	void changeUserPassword(@Param("pwd") String pwd, @Param("id") Long id);
	
	@Modifying
	@Query(value = "UPDATE users u set u.email = :mail where u.id = :id", nativeQuery = true)
	void changeUserEmail(@Param("mail") String mail, @Param("id") Long id);*/

}
