package com.zensar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.entity.Student;
import com.zensar.repository.StudentRepositoryImpl;

public class SpringJdbcMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application context loaded");
		StudentRepositoryImpl studentRepositoryImpl = context.getBean("studentRepository", StudentRepositoryImpl.class);
 
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("yogi");
		student.setStudentAge(28);
		student.setAddress("TENALI");

		studentRepositoryImpl.insert(student);
		studentRepositoryImpl.findById(3);
		studentRepositoryImpl.findByName("RAJU");
		studentRepositoryImpl.deleteStudent(3);
		studentRepositoryImpl.updateStudent(4,"VANI");

	}

}
