package com.emailConfiguration.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "configs")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailConfiguration {
	
	@Id
	private String id;
	private String action;
    private String description;
    private boolean isEnabled;
    private String subject;
    private String body;
    private String template;

}
