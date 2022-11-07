package com.imis.training_cb.advice;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.imis.training_cb.Exception.NoDataFoundException;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity< ErrorObject> handleNoDataFoundException(NoDataFoundException e){
		ErrorObject err=new ErrorObject();
		err.setStatus(HttpStatus.NO_CONTENT.value());
		err.setMessage(e.getMessage());
		return new ResponseEntity<ErrorObject>(err, HttpStatus.OK);
	}
	@ExceptionHandler
	public ResponseEntity< ErrorObject> handleDuplicateKeyException(DuplicateKeyException e){
		ErrorObject err=new ErrorObject();
		err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage(e.getMessage());
		return new ResponseEntity<ErrorObject>(err, HttpStatus.OK);
	}


}
