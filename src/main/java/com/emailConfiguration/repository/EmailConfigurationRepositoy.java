package com.emailConfiguration.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emailConfiguration.entity.EmailConfiguration;

public interface EmailConfigurationRepositoy extends MongoRepository<EmailConfiguration, String> {
	
	Optional<EmailConfiguration> findByAction(String action);

}
