package com.zensar.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springbootDemo.dto.StudentDto;
import com.zensar.springbootDemo.entity.ErrorResponse;
import com.zensar.springbootDemo.entity.Student;
import com.zensar.springbootDemo.exceptions.NoSuchStudentExistsException;
import com.zensar.springbootDemo.exceptions.StudentAlreadyExistsException;
import com.zensar.springbootDemo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/student-api")
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController() {

	}

	/*
	 * @ExceptionHandler(value = StudentAlreadyExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.CONFLICT) public ErrorResponse
	 * handleStudentAlreadyExistsException(StudentAlreadyExistsException ex) {
	 * return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage()); }
	 */
	/*
	 * @ExceptionHandler(value = NoSuchStudentExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.NOT_FOUND) public ErrorResponse
	 * handleNoSuchStudentExistsException(NoSuchStudentExistsException ex) { return
	 * new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()); }
	 */

	// @RequestMapping("/students/{studentId}")
	@Operation(summary = "This is to fetch record by studentId")
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
		// return studentService.getStudent(studentId);
	}

	@GetMapping(value = "/mystudents/{studentId}")
	public ResponseEntity<StudentDto> getStudents(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
		// return studentService.getStudent(studentId);
	}

	// @RequestMapping(value = { "/students", "/listOfStudents" }, method =
	// RequestMethod.GET)
	@Operation(summary = "This is to get all the student records from database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched all records from database", content = {
					@Content(mediaType = "application/json"), @Content(mediaType = "application/xml") }) })
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> getStudents(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "studentName") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "DESC") Direction dir) {
		return new ResponseEntity<List<StudentDto>>(studentService.getStudents(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
		// return studentService.getStudents();
	}

	// @RequestMapping(value = "/students", method = RequestMethod.POST)
	@Operation(summary = "to insert the record into database")
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.insertStudent(studentDto), HttpStatus.CREATED);
		// return studentService.insertStudent(studentDto);
	}

	// @RequestMapping(value = "/students/{studentId}", method =
	// RequestMethod.DELETE)
	@Operation(summary = "This is to delete record by studentId from database")
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}

	// @RequestMapping(value="/students/{studentId}", method = RequestMethod.PUT)
	@Operation(summary = "This is to update record by studentId")
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentService.updateStudent(studentId, studentDto), HttpStatus.OK);
		// return studentService.updateStudent(studentId, studentDto);
	}

	@Operation(summary = "This is to fetch record by studentName")
	@GetMapping(value = "/students/name/{studentName}")
	public ResponseEntity<List<StudentDto>> getByStudentName(@PathVariable("studentName") String studentName) {
		// return studentService.getByStudentName(studentName);
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentName(studentName), HttpStatus.OK);
	}

	@Operation(summary = "This is to fetch record by studentName and Age")
	@GetMapping(value = "/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> getByStudentNameAndStudentAge(@PathVariable String studentName,
			@PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentNameAndStudentAge(studentName, age),
				HttpStatus.OK);
	}

	@Operation(summary = "This is to fetch record having particular student with mentioned name or age")
	@GetMapping(value = "/students/NameOrAge/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> getByStudentNameOrStudentAge(@PathVariable String studentName,
			@PathVariable("studentAge") int age) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentNameOrStudentAge(studentName, age),
				HttpStatus.OK);
	}

	@Operation(summary = "This is to fetch record of student whose name ends with some string")
	@GetMapping(value = "/students/namedsuffix/{suffix}")
	public ResponseEntity<List<StudentDto>> getByStudentNameEndsWith(@PathVariable("suffix") String suffix) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentNameEndsWith(suffix), HttpStatus.OK);
	}

	@Operation(summary = "This is to fetch record in certain order")
	@GetMapping(value = "/students/order/{studentName}")
	public ResponseEntity<List<StudentDto>> findByStudentNameOrderBy(@PathVariable String studentName) {

		return new ResponseEntity<List<StudentDto>>(studentService.findByStudentNameOrderBy(studentName),
				HttpStatus.OK);
	}

}
