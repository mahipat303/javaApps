package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobleException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException u, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), u.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(FIRException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(FIRException u, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), u.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> genralExceptionHandler(Exception u, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), u.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noExceptionHandler(NoHandlerFoundException u, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), u.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> MyIllegalHandler(MethodArgumentNotValidException e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),
				e.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

}
