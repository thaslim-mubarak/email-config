package com.emailConfiguration.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse {
	
	private HttpStatus httpStatus;
    private int statusCode;
    private Object response;

}
