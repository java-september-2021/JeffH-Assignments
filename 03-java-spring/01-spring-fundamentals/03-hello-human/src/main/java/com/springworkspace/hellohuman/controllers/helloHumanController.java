package com.springworkspace.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class helloHumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", defaultValue = "Human") String searchQuery) {
			return "Hello " + searchQuery + "!";
	}
}
