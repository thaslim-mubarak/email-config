package com.emailConfiguration.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class EmailConfigurationDto {
	
	private String id = UUID.randomUUID().toString();
	private String action;
    private String description;
    private boolean isEnabled = true;
    private String subject;
    private String body;
    private String template;

}
