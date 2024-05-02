package com.emailConfiguration.service;

import org.springframework.http.ResponseEntity;

import com.emailConfiguration.dto.ApiResponse;
import com.emailConfiguration.dto.EmailConfigurationDto;
import com.emailConfiguration.dto.EmailTemplate;

public interface EmailConfigurationService {

	ResponseEntity<ApiResponse> createConfig(EmailConfigurationDto emailConfigurationDto);

	ResponseEntity<ApiResponse> updateField(String action, boolean updateField);
	
	ResponseEntity<ApiResponse> updateEmailTemplate(EmailTemplate emailTemplate, String fieldName);

	ResponseEntity<ApiResponse> getTemplateStatus();

	ResponseEntity<ApiResponse> getConfigStatus(String action);
}
