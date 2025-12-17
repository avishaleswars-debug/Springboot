package com.code.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class HtmlController {
	@GetMapping("/hi")
public String getHtml() {
	return "index.html";
}
}
