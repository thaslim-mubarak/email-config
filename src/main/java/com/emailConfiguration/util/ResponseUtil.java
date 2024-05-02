package com.emailConfiguration.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.emailConfiguration.dto.ApiResponse;

@Component
public class ResponseUtil {

	public static ApiResponse apiResponse() {
		return new ApiResponse();
	}

	public static ResponseEntity<ApiResponse> getCreatedResponse(Object object) {
		ApiResponse response = apiResponse();
		response.setHttpStatus(HttpStatus.CREATED);
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setResponse(object);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}

	public static ResponseEntity<ApiResponse> getOkResponse(Object object) {
		ApiResponse response = apiResponse();
		response.setHttpStatus(HttpStatus.OK);
		response.setStatusCode(HttpStatus.OK.value());
		response.setResponse(object);
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}

	public static ResponseEntity<ApiResponse> getBadRequestResponse(Object object) {
		ApiResponse response = apiResponse();
		response.setResponse(object);
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.status(response.getStatusCode()).body(response);
	}
}
