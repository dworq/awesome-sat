package com.awesomesat.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "WORD")
public class Word {
	@Id
	@GeneratedValue
	private Long id;
	private String word;
	// http://docs.jboss.org/hibernate/annotations/3.5/reference/en/html_single/
	// FetchType.EAGER because there aren't that many Meanings for a given Word
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "word_fk")
	private List<Meaning> meanings = new ArrayList<Meaning>();

	@SuppressWarnings("unused")
	public Word() {
		// for Hibernate
	}

	public Word(String word) {
		this.word = word;
	}

	public Long getId() {
		return id;
	}

	public String getWord() {
		return word;
	}

	public void addMeaning(Meaning meaning) {
		// meaning.setWord(this);
		meanings.add(meaning);
	}

	public List<Meaning> getMeanings() {
		return meanings;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", word=" + word + ", meanings=" + meanings
				+ "]";
	}

}