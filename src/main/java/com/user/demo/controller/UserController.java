package com.user.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.models.User;
import com.user.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/hi")
	@ResponseBody
	public String satPing() {
		return "pong";
	}
	
	@PostMapping("/add")
	public User addNewUser(@RequestBody User u) {
		return this.userService.saveOneUser(u);
	}
	
	@GetMapping("/all")
	public List<User> findAllUser(){
		return this.userService.getAllUsers();
	}
	
	@GetMapping("/find/{id}")
	public User findOneUser(@PathVariable("id") long id) {
		return this.userService.getOneUser(id);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOneUser(@PathVariable("id") long id) {
		this.userService.deleteOneUser(id);
		return "user deleted "+id;
	}
	
	@PostMapping("/update")
	public User updateOneUser(@RequestBody User u) {
		return this.userService.updateOneUser(u);
	}
}
