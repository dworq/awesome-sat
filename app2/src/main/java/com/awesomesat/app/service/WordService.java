package com.awesomesat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.awesomesat.app.domain.Word;
import com.awesomesat.app.service.dao.WordDAO;

// why and where use transactions
//http://stackoverflow.com/questions/12997580/how-to-use-spring-hibernate-mysql-isam-with-transactions
@Transactional
@Component
public class WordService {

	@Autowired
	private WordDAO wordDao;

	public void setWordDao(WordDAO wordDao) {
		this.wordDao = wordDao;
	}

	public List<Word> list() {
		return wordDao.list();
	}

	public void save(Word w) {
		wordDao.save(w);
	}

	public Word find(Long id) {
		return wordDao.find(id);
	}

}
