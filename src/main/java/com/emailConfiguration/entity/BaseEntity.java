package com.emailConfiguration.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BaseEntity {
    private String createdOn;
    private String lastUpdateOn;
    private String createdByName;
    private String createdByEmail;
    private String modifiedByName;
    private String modifiedByEmail;
}
