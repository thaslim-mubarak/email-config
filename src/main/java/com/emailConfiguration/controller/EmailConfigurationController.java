package com.emailConfiguration.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.emailConfiguration.dto.ApiResponse;
import com.emailConfiguration.dto.EmailConfigurationDto;
import com.emailConfiguration.dto.EmailTemplate;
import com.emailConfiguration.service.EmailConfigurationService;

@RestController
@RequestMapping(value = "/emailconfig")
@Validated
public class EmailConfigurationController {

	@Autowired
	private EmailConfigurationService emailConfigurationService;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createConfig(@RequestBody @Valid EmailConfigurationDto emailConfigurationDto) {
		return emailConfigurationService.createConfig(emailConfigurationDto);
	}

	@PatchMapping("/update")
	public ResponseEntity<ApiResponse> updateIsEnabled(@RequestParam @NotNull String action,
		@RequestParam boolean isEnabled) {
		return emailConfigurationService.updateField(action, isEnabled);
	}

	@PutMapping("/template")
	public ResponseEntity<ApiResponse> updateEmailTemplate(@RequestBody EmailTemplate emailTemplate,
			@RequestParam @NotNull String action) {
		return emailConfigurationService.updateEmailTemplate(emailTemplate, action);
	}

	@GetMapping("/get")
	public ResponseEntity<ApiResponse> getConfigStatus(@RequestParam @NotNull String action){
		return emailConfigurationService.getConfigStatus(action);
	}

	@GetMapping("/all")
	public ResponseEntity<ApiResponse> getAllConfiguration(){
		return emailConfigurationService.getTemplateStatus();
	}
}
