package com.security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class TestController {
	
	@GetMapping("/signin")
	public String Signin()
	{
		return "login.html";
	}

}
