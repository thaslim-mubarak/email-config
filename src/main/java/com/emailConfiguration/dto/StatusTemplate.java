package com.emailConfiguration.dto;

import lombok.Data;

@Data
public class StatusTemplate {
	
	private String action;
	private boolean isEnabled;
	private String template;

}
