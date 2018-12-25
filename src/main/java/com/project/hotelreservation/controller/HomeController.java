package com.project.hotelreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value="/")
	public String homePage() {
		return  "homepage/index";
	}

	@GetMapping(value="/about")
	public String hotelBooking() {

		return  "homepage/about";
	}


}
