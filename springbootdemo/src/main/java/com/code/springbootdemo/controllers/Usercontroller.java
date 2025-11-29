package com.code.springbootdemo.controllers;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.springbootdemo.model.User;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class Usercontroller {
@GetMapping
public String get() {
	return "hello";
}
	@GetMapping("/user")
	public List<User> getuser() {
	return Arrays.asList(new User(1L,"ajay","ajay@gmail.com"),new User(2L,"vishal","vishal@gmail.com"));
	}
}
