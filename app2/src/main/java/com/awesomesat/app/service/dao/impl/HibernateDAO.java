package com.awesomesat.app.service.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.awesomesat.app.service.dao.GenericDAO;

/***
 * don't use HibernateDaoSupport and HibernateTemplate
 * http://stackoverflow.com/questions/5104765/hibernatedaosupport
 * -is-not-recommended-why
 * http://forum.springsource.org/showthread.php?117227-Missing
 * -Hibernate-Classes-Interfaces-in-spring-orm-3.1.0.RC1
 * */
// http://www.javacodegeeks.com/2012/09/spring-dao-and-service-layer.html
public class HibernateDAO<E, K extends Serializable> implements
		GenericDAO<E, K> {

	@Autowired
	private SessionFactory sessionFactory;
	protected Class<? extends E> daoType;

	@SuppressWarnings("unchecked")
	public HibernateDAO() {
		daoType = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> list() {
		return currentSession().createCriteria(daoType).list();
	}

	@Override
	public void save(E entity) {
		currentSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E find(K key) {
		// http://stackoverflow.com/questions/608947/hibernate-difference-between-session-get-and-session-load
		// .load() throws exception if the object is not found
		// .get() returns null
		return (E) currentSession().get(daoType, key);
	}

}
