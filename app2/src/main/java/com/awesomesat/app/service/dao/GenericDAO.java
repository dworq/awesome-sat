package com.awesomesat.app.service.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, K extends Serializable> {

	public List<E> list();

	public void save(E e);

	public E find(K key);
}
