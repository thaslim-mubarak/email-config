package com.emailConfiguration.dao.impl;

import java.util.List;
import java.util.Optional;

import com.emailConfiguration.dao.EmailConfigurationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emailConfiguration.entity.EmailConfiguration;
import com.emailConfiguration.repository.EmailConfigurationRepositoy;

@Repository
public class EmailConfigurationDaoImpl implements EmailConfigurationDao {
	
	@Autowired
	private EmailConfigurationRepositoy emailConfigurationRepositoy;
	
	public EmailConfiguration createConfig(EmailConfiguration emailConfiguration) {
		return emailConfigurationRepositoy.save(emailConfiguration);
	}
	
	public Optional<EmailConfiguration> getConfig(String fieldName) {
		return emailConfigurationRepositoy.findByAction(fieldName);
	}
	
	public EmailConfiguration update(EmailConfiguration emailConfiguration) {
		return emailConfigurationRepositoy.save(emailConfiguration);
	}
	
	public List<EmailConfiguration> getAll() {
		return emailConfigurationRepositoy.findAll();
	}

}
