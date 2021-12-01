package com.gulukal.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.util.HibernateUtil;

public class _03_aggregatedSum {
	// logger
	private static final Logger logger = LogManager.getLogger(_03_aggregatedSum.class);

	public static void main(String[] args) {

		// session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Java ve sql de isimleri farklı olsa bile javadaki ismini kullanabiliriz
		String hql = "select sum(bigData) from StudentEntity";

		TypedQuery<Integer> typedQuery = session.createQuery(hql, Integer.class);
		Integer bigDataCounter = typedQuery.getSingleResult();
		logger.info(bigDataCounter);
	}
}
