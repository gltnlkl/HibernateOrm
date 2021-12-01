package com.gulukal.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.entity.StudentEntity;
import com.gulukal.util.HibernateUtil;

public class _10_between {

	// logger
	private static final Logger logger = LogManager.getLogger(_10_between.class);

	public static void main(String[] args) {

		// session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// select * from student where tc_number>=5
		int minValue = 55;
		int maxValue = 60;

		String hql = "select stu from StudentEntity as stu where tcNumber between :minKey and :maxKey";

		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);

		typedQuery.setParameter("minKey", minValue);
		typedQuery.setParameter("maxKey", maxValue);

		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();

		for (StudentEntity temp : studentEntities) {

			logger.info(temp);

		}
	}
}