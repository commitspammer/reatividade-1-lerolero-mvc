package com.lerolero.nouns.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("nouns") // "nouns" is the name of the collection in the database
public class Noun {

	@Id
	private String id;  // every document in mongo has an implicit "_id"
	private String plural;  // this field holds the plural form of that noun (example: "Lions")

	/* all attributes have getters and setters */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlural() {
		return plural;
	}

	public void setPlural(String plural) {
		this.plural = plural;
	}

}
