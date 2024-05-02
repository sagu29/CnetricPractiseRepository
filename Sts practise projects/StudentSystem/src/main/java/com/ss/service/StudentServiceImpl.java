package com.ss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ss.entity.Student;
import com.ss.exception.StudentException;
import com.ss.repository.StudentRepository;

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
	public Student updateStudent(Student updatedStudent) {
		// TODO Auto-generated method stub
		
		Student st= sr.findById(updatedStudent.getStId()).orElseThrow(()-> new StudentException("Student not found"));
		
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
		Student st = sr.findById(id).orElseThrow(()-> new StudentException("Student not found with given "+ id));
		sr.deleteById(id);
		return st.getName() + "'s infomation deleted Sucessfully";
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Student getStudentDetailsByEmail(String email) {
		// TODO Auto-generated method stub
		return sr.findByEmail(email).orElseThrow(()-> new StudentException("Student not found by given "+ email));
	}

	@Override
	public String viewDepartmentByStudentId(Integer id) {
		// TODO Auto-generated method stub
		Student st = sr.findById(id).orElseThrow(()-> new StudentException("Student no found by given "+ id));
		return st.getDepartment();
	}

}
