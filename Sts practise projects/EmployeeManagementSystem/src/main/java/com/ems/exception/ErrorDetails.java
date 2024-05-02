package com.ems.exception;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ErrorDetails {

	private LocalDateTime localDateTime;
	private String messeage;
	private String description;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(LocalDateTime localDateTime, String messeage, String description) {
		super();
		this.localDateTime = localDateTime;
		this.messeage = messeage;
		this.description = description;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getMesseage() {
		return messeage;
	}
	public void setMesseage(String messeage) {
		this.messeage = messeage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ErrorDetails [localDateTime=" + localDateTime + ", messeage=" + messeage + ", description="
				+ description + "]";
	}
	
	
	
}