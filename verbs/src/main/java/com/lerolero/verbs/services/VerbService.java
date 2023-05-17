package com.lerolero.verbs.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.lerolero.verbs.repositories.VerbRepository;

@Service
public class VerbService {

	private VerbRepository repo = new VerbRepository();

	private String next() {
		return repo.pullRandom();
	}

	public String randomVerb() {
		return next();
	}

	public List<String> randomVerbList(Integer size) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < size; i++) list.add(next());
		return list;
	}

}
