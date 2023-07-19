package com.defaultsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String Home()
	{
		return "this is home page";
	}
	
	@GetMapping("/admin")
	public String Admin()
	{
		return "this is Admin page";
	}


}
