package com.ss.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalExceptions(Exception ex, WebRequest wr){
		ErrorDetails ed= new ErrorDetails();
		
		ed.setLocalDateTime(LocalDateTime.now());
		ed.setDescription(wr.getDescription(false));
		ed.setMesseage(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundException(NoHandlerFoundException ex, WebRequest wr){
		
		ErrorDetails ed= new ErrorDetails();
		
		ed.setLocalDateTime(LocalDateTime.now());
		ed.setDescription(wr.getDescription(false));
		ed.setMesseage(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorDetails> studentException(StudentException se, WebRequest wr){
		
		ErrorDetails ed= new ErrorDetails();
		
		ed.setLocalDateTime(LocalDateTime.now());
		ed.setDescription(wr.getDescription(false));
		ed.setMesseage(se.getMessage());
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	

}
