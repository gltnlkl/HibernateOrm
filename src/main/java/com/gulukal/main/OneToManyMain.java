package com.gulukal.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.gulukal.relation.oneToMany.Student;
import com.gulukal.relation.oneToMany.Teacher;
import com.gulukal.util.HibernateUtil;

public class OneToManyMain {

	public static void main(String[] args) {
		// her zaman tek olanla baslayalim.
		// 1
		Teacher teacher = new Teacher("Mustafa Kemal", "Ataturk");
		teacher.setStudentList(new ArrayList<Student>());

		// N
		// 1.Student
		Student student = new Student("Hamit", "Mizrak");
		student.setTeacher(teacher);
		teacher.getStudentList().add(student);

		// 2.Student
		Student student2 = new Student("Recep", "Ergan");
		student2.setTeacher(teacher);
		teacher.getStudentList().add(student2);

		// Create
		// Session session = HibernateUtil.getSessionfactory().openSession();
		// session.getTransaction().begin();
		// session.persist(teacher);
		// session.getTransaction().commit();

		System.out.println("*********************************************");
		// find teacher
		Session session = HibernateUtil.getSessionFactory().openSession();
		Teacher teacherFind = session.find(Teacher.class, 1L);
		System.out.println(teacherFind);
		System.out.println("*********************************************");

		// find student
		// select * from teacher_relation as te inner join student_relation as st on
		// te.teacherId=st.teacherId

		// hibernate innerJoin :stu.teacher.teacherId
		String hql = "select stu from Student as stu where stu.teacher.teacherId=1";
		TypedQuery<Student> studentList = session.createQuery(hql, Student.class);
		List<Student> listem = studentList.getResultList();

		for (Object temp : listem) {
			System.out.println(temp);
		}
	}

}