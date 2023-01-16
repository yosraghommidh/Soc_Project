package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.user;
import com.example.demo.service.userService;
@RequestMapping("login")

@RestController

public class userController {
	@Autowired
	private userService service;
	
	@PostMapping("/register")
	 public String register(@RequestBody user user) {
		service.saveUser(user);
		 return "Hi " + user.getEmail() + " your Registration process successfully completed";
	 }
	
	@PostMapping("/login")
	 public String login(@RequestBody user loginDto){
		 return service.login(loginDto);
		 
	 }
	/*
	@PostMapping("/change")
	 public String changepwdUser(@RequestBody user user){
		service.changepwdUser(user);
		service.changemailUser(user);
		return "change sucess";
	 }
	*/
	/*@PostMapping("/changeM")
	 public String changemailUser(@RequestBody Users user){
		service.changemailUser(user);
		return "change sucess";
	 }
	
	@PostMapping("/changeR")
	 public String changeroleUser(@RequestBody Users user){
		service.changeroleUser(user);
		return "change sucess";
	 }*/
	
	@GetMapping("/getAllUsers")
	 public List<user> findAllUsers() {
		return service.findAllUsers();
	 }
	/*
	@GetMapping("/findUser/{id}")
	 public user findUserByid(@PathVariable Long id) {
		 return service.findUserById(id);
	 }
	
	@GetMapping("/findUser/{email}")
	 public user findUser(@PathVariable String email) {
		 return service.findUserByEmail(email);
	 }
	*/
	 @DeleteMapping("/cancel/{id}")
	 public List<user> cancelRegistration(@PathVariable Long id) {
		 service.deleteUserById(id);
		 return service.findAllUsers();
	 }

}
