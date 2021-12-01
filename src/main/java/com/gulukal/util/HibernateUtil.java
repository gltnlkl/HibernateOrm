package com.gulukal.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gulukal.entity.BilgeAdamEntity;
import com.gulukal.entity.ETicaretEntity;
import com.gulukal.entity.PencilEntity;
import com.gulukal.entity.StudentEntity;
import com.gulukal.relation.oneToMany.Student;
import com.gulukal.relation.oneToMany.Teacher;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();

	// method
	private static SessionFactory sessionFactoryHibernate() {
		try {
			// instance
			Configuration configuration = new Configuration();

			// entity classlarımızı buraya ekleyeceğiz
			configuration.addAnnotatedClass(StudentEntity.class);
			configuration.addAnnotatedClass(BilgeAdamEntity.class);
			configuration.addAnnotatedClass(ETicaretEntity.class);
			configuration.addAnnotatedClass(PencilEntity.class);

			// composition
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Teacher.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// dış dünyada bununla bu classa erişim sağlayabileceğim.
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}