package com.lerolero.nouns.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.lerolero.nouns.repositories.NounRepository;

@Service
public class NounService {

	private NounRepository repo = new NounRepository();

	private String next() {
		return repo.pullRandom();
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
