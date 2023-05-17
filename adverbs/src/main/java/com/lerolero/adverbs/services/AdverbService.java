package com.lerolero.adverbs.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.lerolero.adverbs.repositories.AdverbRepository;

@Service
public class AdverbService {

	private AdverbRepository repo = new AdverbRepository();

	private String next() {
		return repo.pullRandom();
	}

	public String randomAdverb() {
		return next();
	}

	public List<String> randomAdverbList(Integer size) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < size; i++) list.add(next());
		return list;
	}

}
