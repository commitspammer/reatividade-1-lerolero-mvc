package com.lerolero.nouns.controllers;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.lerolero.nouns.services.NounService;

@RestController
@RequestMapping("/nouns")
public class NounController {

	@Autowired
	NounService nounService;

	@GetMapping
	public String get() {
		return nounService.randomNoun();
	}

	@GetMapping("/events")
	public SseEmitter subscribe() {
		SseEmitter emitter = new SseEmitter(-1L);
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			try {
				while (true) {
					//Thread.sleep(1000); // simulated delay
					String noun = nounService.randomNoun();
					emitter.send(noun);
				}
			} catch (Exception e) {
				emitter.completeWithError(e);
			} finally {
				emitter.complete();
			}
		});
		executor.shutdown();
		return emitter;
	}

}
