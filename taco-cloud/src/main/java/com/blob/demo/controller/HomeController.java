package com.blob.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping(path = "/")
	public String home() {
		log.info("Executing home method ..");
		return "home";
	}

}
