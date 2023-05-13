package com.lerolero.nouns.controllers;

//import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public String get() {
		return "Hello World!";
	}

}
