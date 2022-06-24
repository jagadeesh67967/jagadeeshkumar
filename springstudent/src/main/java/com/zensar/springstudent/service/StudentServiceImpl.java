package com.zensar.springstudent.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zensar.springstudent.dto.StudentDto;
import com.zensar.springstudent.entity.Student;
import com.zensar.springstudent.exception.NoSuchStudentExistsException;
import com.zensar.springstudent.exception.StudentExistsException;
import com.zensar.springstudent.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto getStudent(int studentId) {
		//Student student = studentRepository.findById(studentId).get();

		// StudentDto dto=mapToDto(student);
		Student getStudent = studentRepository.findById(studentId).orElse(null);
		if(getStudent == null) {
			throw new NoSuchStudentExistsException("Student doesn't exists");
		}
		return modelMapper.map(getStudent, StudentDto.class);

		// return dto;

	}

	@Override
	public List<StudentDto> getAllStudents(int pageNumber,int pageSize) {
		// List<Student> listOfStudent = studentRepository.findAll();
		List<StudentDto> listOfStudentDto = new ArrayList<StudentDto>();

		Page<Student> findAll = studentRepository
				.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Direction.DESC, "studentName")));
		List<Student> content = findAll.getContent();

		for (Student student : content) {
			// listOfProductDto.add(mapToDto(product));
			listOfStudentDto.add(modelMapper.map(student, StudentDto.class));
		}

		return listOfStudentDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student getStudent = studentRepository.findById(student.getStudentId()).get();
		if(getStudent == null) {

		Student insertedStudent = studentRepository.save(student);

		// StudentDto mapToDto=mapToDto(insertedStudent);
		return modelMapper.map(insertedStudent, StudentDto.class);
		}
		else
			throw new StudentExistsException("Student already exists");

		// return mapToDto;
	}

	@Override
	public StudentDto updatedStudent(int studentId, StudentDto studentDto) {
		// Student student = mapToEntity(productDto);
		Student getStudent = studentRepository.findById(studentId).orElse(null);
		if(getStudent == null) {
			throw new NoSuchStudentExistsException("Student doesnt exists");
		}
		Student student = modelMapper.map(studentDto, Student.class);
		Student updatedStudent = studentRepository.save(student);
		return modelMapper.map(updatedStudent, StudentDto.class);
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
	public List<StudentDto> findByStudentName(String studentName) {
		List<StudentDto>studentDto = new ArrayList<>();
		List<Student> students = (List<Student>)studentRepository.findByStudentName(studentName);
		for (Student student : students) studentDto.add(modelMapper.map(student, StudentDto.class));
		return studentDto;
	}

	/*
	 * @Override public List<StudentDto> test(String studentName) { List<StudentDto>
	 * studentDto = new ArrayList<>(); List<Student> students = (List<Student>)
	 * studentRepository.test(studentName); for (Student student : students)
	 * studentDto.add(modelMapper.map(student, StudentDto.class)); return
	 * studentDto; }
	 */

	@Override
	public List<StudentDto> findByStudentNameAndStudentAge(String studentName, int studentAge) {
		 List<StudentDto> studentDto = new ArrayList<>();
		 List<Student> students =(List<Student>) studentRepository.findByStudentNameAndStudentAge(studentName, studentAge);
		 for (Student student : students) studentDto.add(modelMapper.map(student,StudentDto.class));
		 return studentDto;
	}

	/*
	 * @Override public List<StudentDto> test1(String studentName, int studentAge) {
	 * List<StudentDto> studentDto = new ArrayList<>(); List<Student> students =
	 * (List<Student>) studentRepository.test1(studentName, studentAge); for
	 * (Student student : students) studentDto.add(modelMapper.map(student,
	 * StudentDto.class)); return studentDto; }
	 */
	/*
	 * public Student mapToEntity(StudentDto studentDto) {
	 * 
	 * Student student=new Student();
	 * student.setStudentId(studentDto.getStudentId());
	 * student.setStudentName(studentDto.getStudentName());
	 * student.setStudentAge(studentDto.getStudentAge());
	 * 
	 * return student;
	 * 
	 * 
	 * }
	 */

}
