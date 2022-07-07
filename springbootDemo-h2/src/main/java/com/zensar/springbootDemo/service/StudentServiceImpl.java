package com.zensar.springbootDemo.service;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zensar.springbootDemo.dto.StudentDto;
import com.zensar.springbootDemo.entity.Student;
import com.zensar.springbootDemo.exceptions.NoSuchStudentExistsException;
import com.zensar.springbootDemo.exceptions.StudentAlreadyExistsException;
import com.zensar.springbootDemo.repository.StudentRepository;

import org.springframework.data.domain.Sort.Direction;   // important one

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	public StudentServiceImpl() {

	}

	@Override
	public StudentDto getStudent(int studentId) {
		Student getStudent = studentRepository.findById(studentId).orElse(null);
		if(getStudent == null) {
			throw new NoSuchStudentExistsException("Student doesn't exists");
		}
		// StudentDto dto = mapToDto(getStudent);
		return modelMapper.map(getStudent, StudentDto.class);
	}

	@Override
	public List<StudentDto> getStudents(int pageNumber, int pageSize,String sortBy,Direction dir) {
		// List<Student> listOfStudents = studentRepository.findAll();
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber, pageSize,Sort.by(Direction.DESC,"studentName")));
		Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber, pageSize,dir,sortBy));
		List<Student> content = findAll.getContent();
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		for (Student student : content) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student getStudent = studentRepository.findById(student.getStudentId()).orElse(null);
		if(getStudent == null) {
			Student insertedStudent = studentRepository.save(student);
			// StudentDto maptoDto = mapToDto(insertedStudent);
			// return maptoDto;
			return modelMapper.map(insertedStudent, StudentDto.class);
		}
		else 
			throw new StudentAlreadyExistsException("Student already exists");
		

	}

	@Override
	public void deleteStudent(int studentId) {
		Student getStudent = studentRepository.findById(studentId).orElse(null);
		if(getStudent == null) {
			throw new NoSuchStudentExistsException("Student doesnt exists");
		}
		studentRepository.deleteById(studentId);

	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student getStudent = studentRepository.findById(studentId).orElse(null);
		if(getStudent == null) {
			throw new NoSuchStudentExistsException("Student doesnt exists");
		}
		Student student = modelMapper.map(studentDto, Student.class);
		Student updatedStudent = studentRepository.save(student);
		// StudentDto dto = mapToDto(updatedStudent);
		// return dto;
		return modelMapper.map(updatedStudent, StudentDto.class);
	}

	public List<StudentDto> getByStudentName(String studentName) {
		// return studentRepository.findByStudentName(studentName);
		// return studentRepository.test(studentName);
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.test(studentName);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public List<StudentDto> getByStudentNameAndStudentAge(String studentName, int age) {
//		return studentRepository.findByStudentNameAndStudentAge(studentName,age); 		
//		return studentRepository.test1(studentName, age); 
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.test1(studentName, age);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public List<StudentDto> getByStudentNameOrStudentAge(String studentName, int age) {
		// TODO Auto-generated method stub
		// return studentRepository.findByStudentNameOrStudentAge(studentName, age);
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.findByStudentNameOrStudentAge(studentName, age);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public List<StudentDto> getByStudentNameEndsWith(String suffix) {
		// return studentRepository.findByStudentNameEndsWith(suffix);
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.findByStudentNameEndsWith(suffix);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	@Override
	public List<StudentDto> findByStudentNameOrderBy(String studentName) {

		// return studentRepository.findByStudentNameOrderByStudentIdDesc(studentName);
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();
		List<Student> students = studentRepository.findByStudentNameOrderByStudentIdDesc(studentName);
		for (Student student : students) {
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}
		return listOfStudentDto;
	}

	/*
	 * public Student mapToEntity(StudentDto studentDto) { Student student = new
	 * Student(); student.setStudentId(studentDto.getStudentId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge()); return student; }
	 * 
	 * public StudentDto mapToDto(Student student) { StudentDto dto = new
	 * StudentDto(); dto.setStudentId(student.getStudentId());
	 * dto.setStudentName(student.getStudentName());
	 * dto.setStudentAge(student.getStudentAge()); return dto;
	 * 
	 * }
	 */

}
