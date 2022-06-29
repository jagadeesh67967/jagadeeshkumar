package com.zensar.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.zensar.entity.Student;

public class StudentResultExtractor implements ResultSetExtractor<List<Student>> {

	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Student> studentList = new ArrayList<Student>();
		
		while(rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("studentId"));
			student.setStudentName(rs.getString("studentName"));
			student.setStudentAge(rs.getInt("studentAge"));
			student.setAddress(rs.getString("address"));
			
			studentList.add(student);
		}
		return studentList;
	}

}
