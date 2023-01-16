package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.userEntity;
import com.example.demo.userService.userService;
@RequestMapping("login")

@RestController
public class userController {
	@Autowired
	private userService service;
	
	@PostMapping("/register")
	 public String register(@RequestBody userEntity user) {
		service.saveUser(user);
		 return "Hi " + user.getEmail() + " your Registration process successfully completed";
	 }
	
	@PostMapping("/login")
	 public String login(@RequestBody userEntity loginDto){
		 return service.login(loginDto);
	 }
	
	@PostMapping("/change")
	 public String changepwdUser(@RequestBody userEntity user){
		service.changepwdUser(user);
		service.changemailUser(user);
		return "change sucess";
	 }
	
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
	 public List<userEntity> findAllUsers() {
		return service.findAllUsers();
	 }
	
	@GetMapping("/findUser/{id}")
	 public userEntity findUserByid(@PathVariable Long id) {
		 return service.findUserById(id);
	 }
	
	@GetMapping("/findUser/{role}")
	 public List<userEntity> findUserByid(@PathVariable String role) {
		 return service.findUserByRole(role);
	 }
	
	@GetMapping("/findUser/{email}")
	 public userEntity findUser(@PathVariable String email) {
		 return service.findUserByEmail(email);
	 }
	
	 @DeleteMapping("/cancel/{id}")
	 public List<userEntity> cancelRegistration(@PathVariable Long id) {
		 service.deleteUserById(id);
		 return service.findAllUsers();
	 }

}
