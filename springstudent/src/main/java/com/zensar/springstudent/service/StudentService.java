package com.zensar.springstudent.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.springstudent.dto.StudentDto;
import com.zensar.springstudent.entity.Student;

public interface StudentService {
	
public StudentDto getStudent(int studentId);
	
	public List<StudentDto> getAllStudents(int pageNumber,int pageSize);
	
	public StudentDto insertStudent(StudentDto student);
	
	public StudentDto updatedStudent(int studentId,StudentDto studentDto);
	
	public void deleteStudent(int studentId);

	List<StudentDto> findByStudentName(String studentName);
	//List<StudentDto> test(String studentName);
	
    List<StudentDto> findByStudentNameAndStudentAge(String studentName,int studentAge);
    //List<StudentDto> test1(String studentName,int studentAge);


}
