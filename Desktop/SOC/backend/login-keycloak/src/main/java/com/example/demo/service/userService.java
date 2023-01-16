package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
import com.example.demo.repository.repository;

import javax.persistence.*;

@Service
public class userService {
	@Autowired
    private repository repository ;
	
	public String login(user user1) {
		String ch;
		user user = repository.findByEmail(user1.getEmail());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(user1.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        
        ch = "login succes";
        
        return ch ;
    }
	
	public user saveUser (user user) {
		return repository.save(user);
	}
	
	public void deleteUserById (Long id) {
		repository.deleteById(id);
	}
	
	public void deleteUser (user user) {
		repository.delete(user); ;
	}
	/*
	public void changepwdUser (user user) {
		repository.changeUserPassword(user.getPassword(), user.getId());
	}
	
	public void changemailUser (user user) {
		repository.changeUserEmail(user.getEmail(), user.getId());
	}

	public user findUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public user findUserById(Long id) {
		return repository.finduserById(id);
	}
*/
	
	public List<user> findAllUsers() {
		return repository.findAll();
	}

}
