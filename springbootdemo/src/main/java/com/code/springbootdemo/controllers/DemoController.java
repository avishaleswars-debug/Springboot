package com.code.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.springbootdemo.model.User;

@RestController
@Controller
@RequestMapping("/demo")
public class DemoController {
	@GetMapping("/one")
	public User gtuser(){
		return  new User(1L,"hello","helllo@gmail");
	}
	@GetMapping("/{n}")
	public int gtnum(@PathVariable int n) {
		System.out.print(n);
		return n*n;
	}
	@GetMapping("param")
	public int gtparam(@RequestParam int name ,String val ) {
		return name;
	}

}
