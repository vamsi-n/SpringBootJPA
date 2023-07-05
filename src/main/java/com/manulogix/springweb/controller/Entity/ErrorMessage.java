package com.manulogix.springweb.controller.Entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * POJO class that should exist with the entity package to handle Error message and HttpStatus responses to the API
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	private HttpStatus status;
	private String message;
}
