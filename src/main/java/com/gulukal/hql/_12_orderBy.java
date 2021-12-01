package com.gulukal.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.util.HibernateUtil;

//marge = update find=find delete=remove insert=persist select=TypedQuery
public class _12_orderBy {

	// logger
	private static final Logger logger = LogManager.getLogger(_12_orderBy.class);

	public static void main(String[] args) {

		// session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// SELECT tc_number FROM student ORDER BY tc_number ASC|DESC;

		String hql = "select stu.tcNumber from StudentEntity as stu order by stu.tcNumber ASC";

		TypedQuery<Integer> typedQuery = session.createQuery(hql, Integer.class);

		ArrayList<Integer> studentEntities = (ArrayList<Integer>) typedQuery.getResultList();

		for (Integer temp : studentEntities) {

			logger.info(temp);

		}
	}
}