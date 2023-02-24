package com.customer.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> CustomerExceptionHandler(CustomerException e,WebRequest req)
	{
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<ErrorDetails> DepartmentExceptionHandler(DepartmentException e,WebRequest req)
	{
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OperatorException.class)
	public ResponseEntity<ErrorDetails> OperatorExceptionHandler(OperatorException e,WebRequest req)
	{
		ErrorDetails ed=new ErrorDetails(LocalDateTime.now(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
	}
	
}
