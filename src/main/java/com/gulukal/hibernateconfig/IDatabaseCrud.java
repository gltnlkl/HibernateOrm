package com.gulukal.hibernateconfig;

import java.util.ArrayList;

import org.hibernate.Session;

import com.gulukal.util.HibernateUtil;

public interface IDatabaseCrud<T> {
	// CRUD

	public void create(T entity);// ekleme

	public void delete(T entity);// silmek

	public void update(T entity);// güncelleme

	default ArrayList<T> list() {// listeleme
		return null;
	}

	default T find(long l) {
		return null;
	}

	default T singleResult(long id) {
		return null;
	}

	default Session databaseConnectionHibernate() {
		return HibernateUtil.getSessionFactory().openSession();
	}

}
