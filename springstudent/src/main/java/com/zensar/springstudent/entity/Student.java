package com.zensar.springstudent.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "Student.test", query = "from Student s where s.studentName=?1")
//@NamedQuery(name = "Student.test1", query = "from Student s where s.studentName=?1 and s.studentAge=?2")

//@NamedNativeQuery(name = "Student.test", query = "select * from student where student_name=?1",resultClass = Student.class)
//@NamedNativeQuery(name = "Student.test1", query = "select * from student where student_name=?1 and student_age=?2",resultClass = Student.class)
public class Student {
	
	@Id
	private int studentId;
	private String studentName;
	private int studentAge;
	
	public Student() {
		super();
	}

	public Student(int studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge + "]";
	}
	
	

}
