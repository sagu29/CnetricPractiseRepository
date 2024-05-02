package com.ss.service;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss.entity.Student;
import com.ss.exception.StudentException;
import com.ss.repository.StudentRepository;

@Service
public class StudentDetailsService implements UserDetailsService {
	
	private StudentRepository sr;
	
	
	public StudentDetailsService(StudentRepository sr) {
		super();
		this.sr = sr;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> st = sr.findByEmail(username);
		return st.orElseThrow(()-> new StudentException("No Student found of this username "+ username));
	}

}
