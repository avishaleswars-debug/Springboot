package com.code.springbootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HtmlController {
	@GetMapping("/hi")
public String getHtml() {
	return "inhtml";
}
}
