package com.emailConfiguration.dao;

import com.emailConfiguration.entity.EmailConfiguration;

import java.util.List;
import java.util.Optional;

public interface EmailConfigurationDao {

    EmailConfiguration createConfig(EmailConfiguration emailConfiguration);

    Optional<EmailConfiguration> getConfig(String fieldName);

    List<EmailConfiguration> getAll();

    EmailConfiguration update(EmailConfiguration emailConfiguration);
}
