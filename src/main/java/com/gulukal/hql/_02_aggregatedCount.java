package com.gulukal.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.util.HibernateUtil;

public class _02_aggregatedCount {

	// logger
	private static final Logger logger = LogManager.getLogger(_02_aggregatedCount.class);

	public static void main(String[] args) {

		// session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Java ve sql de isimleri farklı olsa bile javadaki ismini kullanabiliriz
		String hql = "select count(tcNumber) from StudentEntity";

		TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);
		Long bigDataCounter = typedQuery.getSingleResult();
		logger.info(bigDataCounter);
	}
}
