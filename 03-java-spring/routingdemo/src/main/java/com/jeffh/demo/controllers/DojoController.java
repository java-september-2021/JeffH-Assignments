package com.jeffh.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/dojo", method=RequestMethod.GET)
public class DojoController {
	@RequestMapping(path="", method=RequestMethod.GET)
	public String dojo() {
		return "The dojo is awesome!";
	}
	
	@RequestMapping(path="/burbank", method=RequestMethod.GET)
	public String burbank() {
		return "Burbank Dojo is located in Southern California.";
	}
	
	@RequestMapping(path="/san-jose", method=RequestMethod.GET)
	public String sanJose() {
		return "SJ dojo is the headquarters.";
	}
}
