package com.ss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.entity.Student;
import com.ss.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService ss;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public StudentController(StudentService ss, PasswordEncoder passwordEncoder) {
		super();
		this.ss = ss;
		this.passwordEncoder = passwordEncoder;
	}
	
	@PostMapping(value= "/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		String encryptPassword= passwordEncoder.encode(student.getPassword());
		student.setPassword(encryptPassword);
		
		return new ResponseEntity<Student>(ss.addStudent(student), HttpStatus.CREATED);
		
	}
	
	@GetMapping(value= "/student/signIn")
	public ResponseEntity<Student> signInStudent(){
		Student st= (Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new ResponseEntity<Student> (st, HttpStatus.CREATED);
	}
	
	@GetMapping(value= "/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		return new ResponseEntity<Student>(ss.getStudentById(id), HttpStatus.OK);
	}
	
//	@PutMapping(value= "/Student")
//	public ResponseEntity<Student> updateStudent(@RequestBody Student st){
//		return new ResponseEntity<Student>(ss.updateStudentById(st), HttpStatus.OK);
//	}
	
	@DeleteMapping(value= "/Student/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id){
		return new ResponseEntity<String>(ss.deleteStudentById(id), HttpStatus.OK);
	}
	
	@GetMapping(value= "/Student")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(ss.getAllStudent(),HttpStatus.OK);
	}
	
//	@GetMapping(value= "/department/{id}")
//	public ResponseEntity<String> viewDepartmentByStudentId(@PathVariable Integer id){
//		return new ResponseEntity<String>(ss.viewDepartmentByStudentId(id), HttpStatus.OK);
//	
	
	@GetMapping(value= "/student/{email}")
	public ResponseEntity<Student> getStudentDetailsByEmail(@PathVariable String email){
		return new  ResponseEntity<Student>(ss.getStudentDetailsByEmail(email), HttpStatus.OK);
	}
	

}
