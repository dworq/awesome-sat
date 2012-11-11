package com.awesomesat.app.service.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.awesomesat.app.domain.Word;
import com.awesomesat.app.service.dao.WordDAO;

@Repository("wordDao")
@Transactional
public class WordDAOImpl extends HibernateDAO<Word, Long> implements WordDAO {

}
