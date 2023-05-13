package com.lerolero.nouns.services;

import org.springframework.stereotype.Service;

@Service
public class NounService {

	private int increment = 0;

	public String randomNoun() {
		return "Hello " + increment++ + "!";
	}

}
