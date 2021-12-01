package com.gulukal.main;

import com.gulukal.controller.StudentController;
import com.gulukal.entity.StudentEntity;

public class StudentEntityMain {

	public static void main(String[] args) {

		add();
//		addMultiple();
//		find();
//		delete();
//		update();
//		list();

	}

	public static void addMultiple() {

		// JPQL
		// HQL

		//// Create
		// String bigData, String studentName, String studentSurname, String
		//// emailAddress,
		// String studentPassword, int tcNumber

		for (int i = 0; i < 10; i++) {
			StudentEntity studentEntity = new StudentEntity("big data " + i, "Gülten " + i, "Ulukal" + i,
					"gulten@gmail.com " + i, "passwords" + i, 100 + i);
			StudentController studentController1 = new StudentController();
			studentController1.create(studentEntity);
		}
	}

	public static void add() {

		StudentEntity studentEntity = new StudentEntity("Deniz", "Yonkuc", "deniz@gmail.com", "455155");
		StudentController studentController1 = new StudentController();
		studentController1.create(studentEntity);

	}

	public static void find() {

		// find
		StudentController studentController2 = new StudentController();
		long id = 1;
		studentController2.find(id);

	}

	public static void delete() {

		// delete
		StudentController studentController3 = new StudentController();
		StudentEntity studentEntity2 = new StudentEntity();
		studentEntity2.setStudentId(2L);
		studentController3.delete(studentEntity2);

	}

	public static void update() {

		// update
		StudentEntity studentEntity4 = new StudentEntity("Ozgur", "Yonkuc±", "ozgur@gmail.com", "111111");
		studentEntity4.setStudentId(1);
		StudentController studentController4 = new StudentController();
		studentController4.update(studentEntity4);

	}

	public static void list() {

		// list
		StudentController studentController4 = new StudentController();
		for (StudentEntity temp : studentController4.list()) {
			System.out.println(temp);
		}

	}
}