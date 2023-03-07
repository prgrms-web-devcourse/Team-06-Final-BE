package com.example.demo.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.ExceptionMessage;

@RestControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ApiResponse> handleEntityNotFoundException(EntityNotFoundException exception) {
		ApiResponse apiResponse = ApiResponse.fail(exception.getMessage());
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalArgumentException exception) {
		ApiResponse apiResponse = ApiResponse.fail(exception.getMessage());
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalStateException exception) {
		ApiResponse apiResponse = ApiResponse.fail(exception.getMessage());
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OAuth2AuthenticationException.class)
	public ResponseEntity<ApiResponse> handleOAuth2AuthenticationException(OAuth2AuthenticationException exception) {
		ApiResponse apiResponse = ApiResponse.fail(exception.getMessage());
		return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ApiResponse> handleNumberFormatException(NumberFormatException exception) {
		ApiResponse apiResponse = ApiResponse.fail(ExceptionMessage.CANNOT_ACCESS_ANONYMOUS.getMessage());
		return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
	}
}
