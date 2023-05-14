package com.lerolero.gateway.controllers;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.lerolero.gateway.services.NounService;

@RestController
@RequestMapping("/nouns")
public class NounController {

	@Autowired
	private NounService nounService;

	@GetMapping
	public List<String> get(@RequestParam(defaultValue = "1") Integer size) {
		return nounService.randomNounList(size);
	}

}
