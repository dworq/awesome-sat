package com.awesomesat.app.service.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.awesomesat.app.domain.Meaning;
import com.awesomesat.app.service.dao.MeaningDAO;

@Repository("meaningDao")
@Transactional
public class MeaningDAOImpl extends HibernateDAO<Meaning, Long> implements
		MeaningDAO {

}
