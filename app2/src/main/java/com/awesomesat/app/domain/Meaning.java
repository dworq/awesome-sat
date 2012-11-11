package com.awesomesat.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.StringUtils;

@Entity(name = "MEANING")
public class Meaning {
	@Id
	@GeneratedValue
	private Long id;
	private String partOfSpeach;
	private String definition;
	private String example;
	// http://docs.jboss.org/hibernate/annotations/3.5/reference/en/html_single/
	@ManyToOne
	@JoinColumn(name = "word_fk", insertable = false, updatable = false)
	private Word word;

	@SuppressWarnings(value = { "unused" })
	private Meaning() {
		// for hibernate
	}

	public Meaning(String partOfSpeach, String definition, String example) {
		this.partOfSpeach = cleanString(partOfSpeach);
		this.definition = cleanString(definition);
		this.example = cleanString(example);
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public String getPartOfSpeach() {
		return partOfSpeach;
	}

	public String getDefinition() {
		return definition;
	}

	public String getExample() {
		return example;
	}

	private String cleanString(String input) {
		input = StringUtils.trim(input);
		input = StringUtils.removeStart(input, "(");
		input = StringUtils.removeEnd(input, ")");
		return input;
	}

	@Override
	public String toString() {
		return "Meaning [partOfSpeach=" + partOfSpeach + ", definition="
				+ definition + ", example=" + example + "]";
	}

}