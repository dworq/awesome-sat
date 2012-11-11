package com.awesomesat.app.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}
