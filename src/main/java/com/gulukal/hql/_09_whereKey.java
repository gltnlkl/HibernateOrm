package com.gulukal.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.entity.StudentEntity;
import com.gulukal.util.HibernateUtil;

public class _09_whereKey {
	// logger
	private static final Logger logger = LogManager.getLogger(_09_whereKey.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// NormalSQL
		// select * from student where tc_number>=5
		
		// String hql = "select stu from StudentEntity as stu where tcNumber>=5";
		String hql = "select stu from  StudentEntity as stu where tcNumber>=:key";
		
		int number = 5;
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		typedQuery.setParameter("key", number);
		
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
		
	}
}