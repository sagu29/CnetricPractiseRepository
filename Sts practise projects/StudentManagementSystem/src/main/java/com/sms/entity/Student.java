package com.sms.entity;

import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Student implements UserDetails, CredentialsContainer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stId;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	@Column(unique= true)
	private String email;
	
	@NotNull
	private String contactNumber;
	
	@NotNull
	private String department;
	
	@NotNull
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		this.password= null;
		
	}
	
	//private String role;
	
	

//	public Student( int stId, @NotNull String name, @NotNull String email, @NotNull String contactNumber,
//			@NotNull String department) {
//		super();
//		this.stId = stId;
//		this.name = name;
//		this.email = email;
//		this.contactNumber = contactNumber;
//		this.department = department;
//	}
//
//	public int getStId() {
//		return stId;
//	}
//
//	public void setStId(int stId) {
//		this.stId = stId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getContactNumber() {
//		return contactNumber;
//	}
//
//	public void setContactNumber(String contactNumber) {
//		this.contactNumber = contactNumber;
//	}
//
//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public Student() {
//		super();
//	}


	
	

}
