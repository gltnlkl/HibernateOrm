package com.gulukal.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.entity.StudentEntity;
import com.gulukal.util.HibernateUtil;

public class _01_selectQuery {

	private static final Logger logger = LogManager.getLogger(_01_selectQuery.class);

	public static void main(String[] args) {

		selectQuery();

	}

	public static void selectQuery() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		// select * from student;
		// fromdan sonra tablo adi yazmayacagiz Student Entity yazilacak...

		String hql = "SELECT stu FROM StudentEntity AS stu";

		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);

		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();

		for (StudentEntity temp : studentEntities) {

			logger.info(temp);

		}
	}

}
