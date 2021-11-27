package hu.me.iit.Computer.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hu.me.iit.Computer.Exceptions.NoSuchEntityException;
import hu.me.iit.Computer.Exceptions.NoSuchManufacturerException;

@ControllerAdvice
public class RestEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value=NoSuchEntityException.class)
	protected ResponseEntity<Object> handleNoSuchElement(RuntimeException ex, WebRequest request){
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),HttpStatus.NOT_FOUND,request);
	}
	@ExceptionHandler(value=NoSuchManufacturerException.class)
	protected ResponseEntity<Object> handleNoSuchManufacturer(RuntimeException ex, WebRequest request){
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),HttpStatus.NOT_FOUND,request);
	}
}
