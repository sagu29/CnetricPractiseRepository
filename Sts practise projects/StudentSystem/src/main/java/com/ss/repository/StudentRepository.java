package com.ss.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Optional<Student> findByEmail(String email);

}
