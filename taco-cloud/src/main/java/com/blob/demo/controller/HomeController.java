package com.blob.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping(path = "/")
	public String home(final HttpServletResponse response) {
		log.info("Executing home method ..");
		response.addHeader("taco", "funny");
		return "home";
	}

}
