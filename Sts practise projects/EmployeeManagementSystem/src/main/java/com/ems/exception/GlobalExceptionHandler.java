package com.ems.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import com.ems.exception.ErrorDetails;
//import java.time.LocalDateTime;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetails> generalExceptionHandler(Exception ex, WebRequest request) {
//        //log.error("An unexpected error occurred", ex);
//       // return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
//    return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false), LocalDateTime.now()), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<ErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException ex, WebRequest request) {
//        //log.warn("No handler found for the requested endpoint" , ex);
//        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorDetails> notValidExceptionHandler(MethodArgumentNotValidException ex, WebRequest request) {
//        log.warn("Invalid request arguments" , ex);
//        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.BAD_REQUEST);
//    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalExceptions(Exception se, WebRequest wr){
		
		ErrorDetails ed= new ErrorDetails();
		ed.setLocalDateTime(LocalDateTime.now());
		ed.setDescription(wr.getDescription(false));
		ed.setMesseage(se.getMessage());
		
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
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorDetails> employeeException(EmployeeException ex, WebRequest wr){
		ErrorDetails ed= new ErrorDetails();
		ed.setLocalDateTime(LocalDateTime.now());
		ed.setDescription(wr.getDescription(false));
		ed.setMesseage(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
    
}
