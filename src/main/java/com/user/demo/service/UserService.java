package com.user.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.demo.models.User;
import com.user.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	public User getOneUser(long id){
		return this.userRepository.findById(id).get();
	}
	
	public String deleteOneUser(long id){
		 this.userRepository.deleteById(id);
		 return String.format("user deleted %s", id);
	}
	public User updateOneUser(User u){
		 return this.userRepository.save(u);
	}
	
	public User saveOneUser(User u){
		 return this.userRepository.save(u);
	}
}
