package com.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Student;
import com.sms.service.StudentService;

@RestController
public class StudentController {
	
	private StudentService ss;
	
	private PasswordEncoder passwordEncoder;
	

	
	@Autowired
	public StudentController(StudentService ss, PasswordEncoder passwordEncoder) {
		super();
		this.ss = ss;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping(value= "/Student")
	public ResponseEntity<Student> addStudent(@RequestBody Student st){
		st.setPassword(passwordEncoder.encode(st.getPassword()));
		Student regStudent = ss.addStudent(st);
		return new ResponseEntity<Student>(regStudent, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value= "/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		return new ResponseEntity<Student>(ss.getStudentById(id), HttpStatus.OK);
	}
	
	@PutMapping(value= "/Student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student st){
		return new ResponseEntity<Student>(ss.updateStudentById(st), HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/Student/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id){
		return new ResponseEntity<String>(ss.deleteStudentById(id), HttpStatus.OK);
	}
	
	@GetMapping(value= "/Student")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(ss.getAllStudent(),HttpStatus.OK);
	}
	
	@GetMapping(value= "/department/{id}")
	public ResponseEntity<String> viewDepartmentByStudentId(@PathVariable Integer id){
		return new ResponseEntity<String>(ss.viewDepartmentByStudentId(id), HttpStatus.OK);
	}
	
	
	@GetMapping("Student/signIn")
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){
	System.out.println(auth); // this Authentication object having Principle object details
	Student customer= ss.getStudentDetailsByEmail(auth.getName());
	return new ResponseEntity<>(customer.getName()+"Logged In Successfully", HttpStatus.ACCEPTED);
	}

}
