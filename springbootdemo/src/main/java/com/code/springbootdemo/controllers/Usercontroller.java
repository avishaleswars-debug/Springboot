package com.code.springbootdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.springbootdemo.entity.UserEntity;
//import com.code.springbootdemo.model.User;
import com.code.springbootdemo.repository.UserRepository;

@RestController
@RequestMapping("/hello")
public class Usercontroller {
	@Autowired
	private UserRepository repo;
//@GetMapping
//public String get() {
//	return "hello";
//}
//	@GetMapping("/user")
	@GetMapping()
	public List<UserEntity> getuser() {
	//return Arrays.asList(new User(1L,"ajay","ajay@gmail.com"),new User(2L,"vishal","vishal@gmail.com"));
		return repo.findAll();
	}
}
