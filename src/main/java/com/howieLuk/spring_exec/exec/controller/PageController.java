package com.howieLuk.spring_exec.exec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/studentPage")
	public String index() {
		return "student";
	}
	
}
