package com.lerolero.nouns.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.lerolero.nouns.repositories.MongoNounRepository;
import com.lerolero.nouns.models.Noun;

@Service
public class NounService {

	@Autowired
	private MongoNounRepository repo; // autowiring the new Repository which uses MongoDB

	private String next() {
		//return repo.pullRandom().getPlural();    // IGNORE THIS, findAll() NEEDS A FIX

		return repo.findAll().get(0).getPlural();  // FIXME this throws IndexOutOfBoundsException!!!
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
