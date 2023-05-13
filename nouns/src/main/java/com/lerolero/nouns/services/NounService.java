package com.lerolero.nouns.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class NounService {

	private int increment = 0;

	private String next() {
		return "Hello " + increment++ + "!";
	}

	public String randomNoun() {
		return next();
	}

	public List<String> randomNounList(Integer size) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < size; i++) list.add(next());
		return list;
	}

}
