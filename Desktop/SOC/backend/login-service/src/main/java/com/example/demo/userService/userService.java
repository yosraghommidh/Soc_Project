package com.example.demo.userService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao;
import com.example.demo.entity.userEntity;

@Service
public class userService {
	@Autowired
    private dao repository ;
	
	public String login(userEntity user1) {
		String ch;
		userEntity user = repository.findByEmail(user1.getEmail());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(user1.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        
        ch = "login succes";
        
        return ch ;
    }
	
	public userEntity saveUser (userEntity user) {
		return repository.save(user);
	}
	
	public void deleteUserById (Long id) {
		repository.deleteById(id);
	}
	
	public void deleteUser (userEntity user) {
		repository.delete(user); ;
	}
	
	public void changepwdUser (userEntity user) {
		repository.changeUserPassword(user.getPassword(), user.getId());
	}
	
	public void changemailUser (userEntity user) {
		repository.changeUserEmail(user.getEmail(), user.getId());
	}

	public userEntity findUserByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public userEntity findUserById(Long id) {
		return repository.finduserById(id);
	}
	
	public List<userEntity> findUserByRole(String role) {
		return repository.findUserByRole(role);
	}
	
	public List<userEntity> findAllUsers() {
		return repository.findAll();
	}
}
