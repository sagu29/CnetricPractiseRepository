package com.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.exception.EmployeeException;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository er;
	
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository er) {
		super();
		this.er = er;
	}

	@Override
	public Employee addEmploye(Employee e) {
		// TODO Auto-generated method stub
		return er.save(e);
	}

	@Override
	public Employee getEmployeeById(Integer eid) {
		// TODO Auto-generated method stub
		
		Employee emp= er.findById(eid).orElseThrow(()-> new EmployeeException("Employee Not found of this " + eid ));
		return emp;
		
	}

}
