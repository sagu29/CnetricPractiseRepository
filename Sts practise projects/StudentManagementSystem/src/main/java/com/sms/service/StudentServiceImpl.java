package com.sms.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.exception.StudentException;
import com.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository sr;
	
	
	public StudentServiceImpl(StudentRepository sr) {
		super();
		this.sr = sr;
	}

	@Override
	public Student addStudent(Student st) {
		// TODO Auto-generated method stub
		if(st== null) {
			throw new StudentException("Student is null");
		}
		return sr.save(st);
		
	}

	@Override
	public Student getStudentById(Integer stId) {
		// TODO Auto-generated method stub
		return sr.findById(stId).orElseThrow(()-> new StudentException("Student not found with given id"+ stId));
		
		
		
	}

	@Override
	public Student updateStudentById(Student updatedStudent) {
		// TODO Auto-generated method stub
		Student st = sr.findById(updatedStudent.getStId()).orElseThrow(()-> new StudentException("Student not found") );
		//Student student = st.get();
			
			st.setName(updatedStudent.getName());
			st.setDepartment(updatedStudent.getDepartment());
			st.setEmail(updatedStudent.getEmail());
			st.setStId(updatedStudent.getStId());
			st.setContactNumber(updatedStudent.getContactNumber());
			st.setPassword(updatedStudent.getPassword());
			return sr.save(st);
		
	}

	@Override
	public String deleteStudentById(Integer id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
		return "Student deleted Successfully";
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return sr.findAll(); 
	}
	
	@Override
	public String viewDepartmentByStudentId(Integer id) {
		// TODO Auto-generated method stub
		Student st = sr.findById(id).orElseThrow(()-> new StudentException("Student not found with given id"+ id));
		return st.getDepartment();
	}

	@Override
	public Student getStudentDetailsByEmail(String email) {
		// TODO Auto-generated method stub
		
		return sr.findByEmail(email).orElseThrow(()-> new StudentException("Student not found by given "+ email));
	}
	

}
