package com.zensar.springstudent.controller;

import java.util.List;

import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springstudent.dto.StudentDto;
import com.zensar.springstudent.entity.Student;
import com.zensar.springstudent.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/student-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE })
public class StudentController {

	@Autowired
	private StudentService StudentService;

	// @RequestMapping("/student/{studentId}")
	@Operation(summary = "This is to fetch record by studentId")
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
		return new ResponseEntity<StudentDto>(StudentService.getStudent(studentId), HttpStatus.OK);

	}

	@GetMapping("/students/studentname/{studentName}")
	public ResponseEntity<List<StudentDto>> findByStudentName(@PathVariable("studentName") String studentName) {
		return new ResponseEntity<List<StudentDto>>(StudentService.findByStudentName(studentName), HttpStatus.FOUND);

	}

	/*
	 * @GetMapping("/students/studentname/{studentName}") public
	 * ResponseEntity<List<StudentDto>> test(@PathVariable("studentName") String
	 * studentName) { return new
	 * ResponseEntity<List<StudentDto>>(StudentService.test(studentName),
	 * HttpStatus.FOUND); }
	 */

	@GetMapping(value = "/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentNameAndStudentAge(
			@PathVariable("studentName") String studentName, @PathVariable("studentAge") int studentAge) {
		return new ResponseEntity<List<StudentDto>>(
				StudentService.findByStudentNameAndStudentAge(studentName, studentAge), HttpStatus.FOUND);

	}

	/*
	 * @GetMapping(value = "/students/{studentName}/{studentAge}") public
	 * ResponseEntity<List<StudentDto>> test1(@PathVariable("studentName") String
	 * studentName,
	 * 
	 * @PathVariable("studentAge") int studentAge) { return new
	 * ResponseEntity<List<StudentDto>>(StudentService.test1(studentName,
	 * studentAge), HttpStatus.FOUND); }
	 */

	// @RequestMapping(value = "/students",method = RequestMethod.GET)
	@Operation(summary = "This is to get all the student records from database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched all records from database", content = {
					@Content(mediaType = "application/json"), @Content(mediaType = "application/xml") }) })
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> getAllStudents(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize,
			@RequestParam(value = "sortby", required = false, defaultValue = "studentName") String studentName,
			@RequestParam(value = "direction", required = false, defaultValue = "DESC") String product) {
		return new ResponseEntity<List<StudentDto>>(StudentService.getAllStudents(pageNumber, pageSize),
				HttpStatus.FOUND);
	}

	// @RequestMapping(value="/students",method = RequestMethod.POST)
	@Operation(summary = "to insert the record into database")
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(StudentService.insertStudent(studentDto), HttpStatus.CREATED);

	}

	// @RequestMapping(value = "/students/{studentId}",method = RequestMethod.PUT)
	@Operation(summary = "This is to update record by studentId")
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updatedStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {

		StudentService.updatedStudent(studentId, studentDto);

		return new ResponseEntity<String>("Sucessfully UPDATED", HttpStatus.OK);

	}

	// @RequestMapping(value = "/students/{studentId}",method =
	// RequestMethod.DELETE)
	@Operation(summary = "This is to delete record by studentId from database")
	@DeleteMapping(value = "/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {

		StudentService.deleteStudent(studentId);

		return new ResponseEntity<String>("Sucessfully Deleted", HttpStatus.OK);

	}

}
