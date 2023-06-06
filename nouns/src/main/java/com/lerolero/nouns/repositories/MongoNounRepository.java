package com.lerolero.nouns.repositories;

import java.util.List;
import java.util.Optional;

import com.lerolero.nouns.models.Noun;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Aggregation;
//import org.springframework.data.jpa.repository.Query;	

public interface MongoNounRepository extends MongoRepository<Noun,String> {

	////@Aggregation({ "{ '$sample': { size: 1 } }" })
	////@Aggregation({ "{ '$sample': { size: ?1 } }" })
	////@Aggregation({ "{ $sample: { size: 1 } }" })
	//@Aggregation("{ $sample: { size: 1 } }")
	//public Noun pullRandom();                            // IGNORE THIS, NounService CALLS findAll()...

	//public Optional<Noun> findByPlural(String plural);   // IGNORE THIS, NounService CALLS findAll()...

	// FIXME
	// findAll() is inherited from MongoRepository
	// findAll() should return List<Noun>
	// and it does, but the list is always empty no matter what...
	// FIXME

}
