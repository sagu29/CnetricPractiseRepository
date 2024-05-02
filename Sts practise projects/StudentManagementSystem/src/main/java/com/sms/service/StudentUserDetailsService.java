package com.sms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.repository.StudentRepository;

@Service
public class StudentUserDetailsService implements UserDetailsService {
	
	
	StudentRepository sr;
	
	
	public StudentUserDetailsService(StudentRepository sr) {
		super();
		this.sr = sr;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Student> opt= sr.findByEmail(username);
		if(opt.isPresent()) {
			Student st= opt.get();
		//Empty Authorities
		List<GrantedAuthority> authorities= new ArrayList<>();
		//authorities.add(new SimpleGrantedAuthority(st.getRole()));
		return new User(st.getEmail(), st.getPassword(), authorities);
		//return new CustomerUserDetails(st);
		}else
		throw new BadCredentialsException("User Details not found with this username: "+username);
	}
	
	

}
