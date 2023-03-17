package com.victory.system.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionAdviceHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> jsonParameterEmptyException(MethodArgumentNotValidException e) {

		log.error(e.getMessage());

		BindingResult result = e.getBindingResult();

		String resultString = "";
		if (result.hasErrors()) {
			List<FieldError> list = result.getFieldErrors();
			resultString = "bad request\n";
			for (FieldError fe : list) {
				resultString  +="Validation error "  +  e.getObjectName()+"." + fe.getField() + "  : " + fe.getDefaultMessage() + "\n";
			}
		}

		return new ResponseEntity<>(resultString, HttpStatus.BAD_REQUEST);
	}
}
