package com.zensar.springstudent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zensar.springstudent.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByStudentName(String studentName);
	// @Query("from Student s where s.studentName=?1")
	//@Query(value = "select * from student where student_name=?1" , nativeQuery = true)
	//List<Student> test(String studentName);

	List<Student> findByStudentNameAndStudentAge(String studentName, int studentAge);
	// @Query("from Student s where s.studentName=?1 and s.studentAge=?2")
	//@Query(value = "select * from student where student_name=?1 and student_age=?2" , nativeQuery = true)
	//List<Student> test1(String studentName,int studentAge);

}
