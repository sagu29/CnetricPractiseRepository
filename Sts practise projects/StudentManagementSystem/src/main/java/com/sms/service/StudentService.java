package com.sms.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.sms.entity.Student;

public interface StudentService {
	
	public Student addStudent(Student st);
	public Student getStudentById(Integer stId);
	public Student updateStudentById(Student updatedStudent);
	public String deleteStudentById(Integer id);
	public List<Student> getAllStudent();
	public String viewDepartmentByStudentId(Integer id);
	public Student getStudentDetailsByEmail(String email);
	
	
	//public UserDetails loadUserByUsername(Integer id);
	
	
	

}
