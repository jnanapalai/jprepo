package com.example.demo;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExcepiton(Exception ex,WebRequest req)
	{
		ErrorDetails err=new ErrorDetails(new Date(),ex.getMessage(),ex.getLocalizedMessage());
		req.getDescription(false);
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
    @ExceptionHandler(DemoCusotmException.class)
	public ResponseEntity<ErrorDetails> handleStudentExcepiton(DemoCusotmException ex,WebRequest req)
	{
    	
    	return new ResponseEntity<ErrorDetails>(
    			new ErrorDetails(new Date(),ex.getMessage(),ex.getLocalizedMessage()),
    			HttpStatus.NOT_FOUND
    			);
    			
    			
	}
}
