package com.gulukal.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.util.HibernateUtil;

public class _06_aggregatedAvg {
	// logger
	private static final Logger logger = LogManager.getLogger(_06_aggregatedAvg.class);

	public static void main(String[] args) {

		// session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// Java ve sql de isimleri farklı olsa bile javadaki ismini kullanabiliriz
		String hql = "select avg(tcNumber) from StudentEntity";

		TypedQuery<Double> typedQuery = session.createQuery(hql, Double.class);
		Double bigDataCounter = typedQuery.getSingleResult();
		logger.info(bigDataCounter);
	}
}
