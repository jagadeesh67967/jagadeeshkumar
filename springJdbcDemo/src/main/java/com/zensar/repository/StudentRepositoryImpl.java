package com.zensar.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.entity.Student;
import com.zensar.extractor.StudentResultExtractor;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

	// private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource()); //.xml
	// file

	@Autowired
	private JdbcTemplate jdbcTemplate; // JDBCTEMPLATE CLASS

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Student student) {

		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";

		Object[] args = { student.getStudentId(), student.getStudentName(), student.getStudentAge(),
				student.getAddress() };

		int noOfRowsInserted = jdbcTemplate.update(sql, args);
		System.out.println("Rows inserted " + noOfRowsInserted);
	}

	public List<Student> findById(int studentId) {
		String sql = "SELECT * FROM STUDENT WHERE studentId=?";
		List<Student> students = jdbcTemplate.query(sql, new StudentResultExtractor(), studentId);
		System.out.println(students);
		return students;
	}

	public void updateStudent(int studentId,String studentName) {
		String sql = "UPDATE student SET studentname=? WHERE studentId=?";

		Object args[] = {studentName, studentId };

		int update = jdbcTemplate.update(sql, args);
		System.out.println("updated"+update);

	}

	public void deleteStudent(int studentId) {
		String sql = "DELETE FROM student WHERE studentId=?";
		Object args[] = {studentId};
		int delete = jdbcTemplate.update(sql, args);
		System.out.println("Deleted"+delete);

	}

	public List<Student> findByName(String studentName) {
		String sql = "SELECT * FROM STUDENT WHERE studentName=?";
		List<Student> students = jdbcTemplate.query(sql, new StudentResultExtractor(), studentName);
		System.out.println(students);
		return students;
	}

}
