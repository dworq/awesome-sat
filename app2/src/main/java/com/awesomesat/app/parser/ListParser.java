package com.awesomesat.app.parser;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.awesomesat.app.domain.Meaning;
import com.awesomesat.app.domain.Word;
import com.awesomesat.app.persistence.HibernateUtil;

public class ListParser {

	private static final String FILE_NAME = "250-word-list.txt";

	private static final String LETTER = "^[a-zA-Z]{1}$";
	private static final String WORD = "^[a-zA-Z]+$";
	private static final Pattern MEANING = Pattern
			.compile("(\\d\\.\\s+)?(\\(\\w+\\.\\)){1}\\s+(.+)\\s+(\\(.+\\))");

	public static void main(String[] args) throws IOException {

		List<Word> words = parseWords();
		persist(words);
	}

	public static List<Word> parseWords() {
		List<Word> words = new ArrayList<Word>();
		InputStream stream = null;
		try {

			stream = ListParser.class.getResourceAsStream(FILE_NAME);
			DataInputStream input = new DataInputStream(stream);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					input, "UTF-8"));
			String line;
			Word word = null;
			while ((line = reader.readLine()) != null) {
				System.out.println("\nInput: " + line);
				line = StringUtils.trim(line);
				// skip ABC
				if (line.matches(LETTER)) {
					continue;
				}
				if (line.matches(WORD)) {
					word = new Word(line);
					words.add(word);
					System.out.println(word);
				}
				Matcher m = MEANING.matcher(line);
				if (m.matches()) {
					String partOfSpeach = m.group(2);
					String definition = m.group(3);
					String example = m.group(4);
					Meaning meaning = new Meaning(partOfSpeach, definition,
							example);
					word.addMeaning(meaning);
					System.out.println(meaning);
				}
			}
		} catch (Exception e) {
			try {
				stream.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return words;
	}

	private static void persist(List<Word> words) {
		System.out.println("saving in the database...");
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		for (Word word : words) {
			session.save(word);
		}
		transaction.commit();
		System.out.println("data saved in database");
	}

}
