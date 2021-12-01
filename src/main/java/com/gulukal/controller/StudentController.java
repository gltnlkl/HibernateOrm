package com.gulukal.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.entity.StudentEntity;
import com.gulukal.hibernateconfig.IDatabaseCrud;

public class StudentController implements Serializable, IDatabaseCrud<StudentEntity> {

	private static final long serialVersionUID = -1213775719782464391L;

	// logger --->

	private static final Logger logger = LogManager.getLogger(StudentController.class); // logger class i import edildi

//  bunu sor neden yazdik ????
//	public static void logger() {
//
//	}

	public static void main(String[] args) {

		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");

	}

	// DML:Create Delete Update : transaction
	// DQL:select
	// create:persist
	// delete:remove
	// find:find kullanilir
	// update:marge

	@Override
	public void create(StudentEntity entity) {

		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + StudentController.class);

		} catch (Exception e) {
			e.printStackTrace();

			logger.error("ekleme esnasinda hata meydana geldi!" + StudentController.class);
		}

	}

	@Override
	public void delete(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.remove(findEntity);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("silme esnasinda hata meydana geldi!" + StudentController.class);
		}

	}

	@Override
	public void update(StudentEntity entity) {

		try {

			StudentEntity findEntity = find(entity.getStudentId());

			if (findEntity != null) {
				findEntity.setEmailAddress(entity.getEmailAddress());
				findEntity.setStudentName(entity.getStudentName());
				findEntity.setStudentPassword(entity.getStudentPassword());
				findEntity.setStudentSurname(entity.getStudentSurname());

				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Guncelleme basarili" + StudentEntity.class);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("guncelleme esnasinda hata meydana geldi!" + StudentController.class);
		}
	}

	@Override
	public ArrayList<StudentEntity> list() {

		Session session = databaseConnectionHibernate();

		String hql = "select str from StudentEntity as str where str.id>=:key";

		TypedQuery<StudentEntity> typeQuery = session.createQuery(hql, StudentEntity.class);

		long id = 1L;
		typeQuery.setParameter("key", id);

		ArrayList<StudentEntity> arrayList = (ArrayList<StudentEntity>) typeQuery.getResultList();
		return arrayList;
	}

	@Override
	public StudentEntity find(long id) {

		Session session = databaseConnectionHibernate();
		StudentEntity studentEntity;
		try {
			studentEntity = session.find(StudentEntity.class, id);

			if (studentEntity != null) {
				logger.info("bulundu..." + studentEntity);
				return studentEntity;
			} else {
				logger.info("arradiginiz sonuclar bulunamadi...");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("listeleme esnasinda hata meydana geldi!" + StudentController.class);
		}
		return IDatabaseCrud.super.find(id);
	}

	@Override
	public StudentEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}

}
