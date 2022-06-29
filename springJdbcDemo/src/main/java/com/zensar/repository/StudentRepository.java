package com.zensar.repository;

import java.util.List;

import com.zensar.entity.Student;

public interface StudentRepository {

	void insert(Student student);

	void updateStudent(int studentId,String studentName);

	void deleteStudent(int studentId);
	
	List<Student> findById(int studentId);

	List<Student> findByName(String studentName);
}
