package com.gulukal.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gulukal.entity.BilgeAdamEntity;
import com.gulukal.hibernateconfig.IDatabaseCrud;

public class BilgeAdamController implements Serializable, IDatabaseCrud<BilgeAdamEntity> {

	private static final long serialVersionUID = -1213775719782464391L;
	private static final Logger logger = LogManager.getLogger(BilgeAdamController.class); // logger classi import
	// all < trace=yesil < debug=yesil < info=yesil < warn=sari < error=kirmizi <
	// fatal=kirmiz < off

	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}

	// DML:Create Delete Update : transaction
	// DQL:select : transaction istege bagli
	// create:persist
	// delete: remove
	// update: merge
	// find : find

	// Ekleme
	@Override
	public void create(BilgeAdamEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdir" + BilgeAdamController.class);
		} catch (Exception e) {
			logger.error("ekleme aninda hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
	}

	// silmek
	@Override
	public void delete(BilgeAdamEntity entity) {

		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Basarili " + BilgeAdamEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme aninda hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}

	}

	// güncellemek
	@Override
	public void update(BilgeAdamEntity entity) {
		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setEmail(entity.getEmail());

				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Basarili " + BilgeAdamEntity.class);
			}

		} catch (Exception e) {
			logger.error("güncelleme aninda hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
	}

	// listelemek
	@Override
	public ArrayList<BilgeAdamEntity> list() {
		Session session = databaseConnectionHibernate();

		// unutma: buradaki sorgulama entity sorgulamasi yani java classina gore
		// cagiracagiz.
		String hql = "select str from BilgeAdamEntity as str where str.id>=:key";
		TypedQuery<BilgeAdamEntity> typedQuery = session.createQuery(hql, BilgeAdamEntity.class);

		long id = 1L;
		typedQuery.setParameter("key", id);

		ArrayList<BilgeAdamEntity> arrayList = (ArrayList<BilgeAdamEntity>) typedQuery.getResultList();
		logger.info("listelendi " + BilgeAdamEntity.class);
		return arrayList;
	}

	// find
	@Override
	public BilgeAdamEntity find(long id) {
		Session session = databaseConnectionHibernate();
		BilgeAdamEntity bilgeAdamEntity;
		try {
			bilgeAdamEntity = session.find(BilgeAdamEntity.class, id);

			if (bilgeAdamEntity != null) {
				System.out.println("bulundu... " + bilgeAdamEntity);
				return bilgeAdamEntity;
			} else {
				System.out.println("Aradiginiz kriterde sonuclar bulunamadi ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find aninda hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
		return null;
	}

	// tek kayit donder
	@Override
	public BilgeAdamEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}

}