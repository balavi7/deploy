package com.example1.demo1controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personcontroller {

	@RequestMapping("/")
	public String getname() {
		return "HelloWorld";
	}
}
