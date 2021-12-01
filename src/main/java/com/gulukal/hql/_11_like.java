package com.gulukal.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.entity.StudentEntity;
import com.gulukal.util.HibernateUtil;

//marge = update find=find delete=remove insert=persist select=TypedQuery
public class _11_like {

	// logger
	private static final Logger logger = LogManager.getLogger(_11_like.class);

	public static void main(String[] args) {

		// session
		Session session = HibernateUtil.getSessionFactory().openSession();

		// select * from student as st where st.student_surname like ('%4');

		String hql = "select stu from StudentEntity as stu where stu.studentSurname like '%4'";

		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);

		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();

		for (StudentEntity temp : studentEntities) {

			logger.info(temp);

		}
	}
}