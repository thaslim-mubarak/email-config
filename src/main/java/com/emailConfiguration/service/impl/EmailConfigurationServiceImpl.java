package com.emailConfiguration.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emailConfiguration.dao.EmailConfigurationDao;
import com.emailConfiguration.dto.ApiResponse;
import com.emailConfiguration.dto.EmailConfigurationDto;
import com.emailConfiguration.dto.EmailTemplate;
import com.emailConfiguration.dto.StatusTemplate;
import com.emailConfiguration.entity.EmailConfiguration;
import com.emailConfiguration.service.EmailConfigurationService;
import com.emailConfiguration.util.ResponseUtil;

import io.micrometer.common.util.StringUtils;

@Service
public class EmailConfigurationServiceImpl implements EmailConfigurationService{
	
	@Autowired
	private EmailConfigurationDao emailConfigurationDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmailTemplateService emailTemplateService;
	
	@Override
	public ResponseEntity<ApiResponse> createConfig(EmailConfigurationDto emailConfigurationDto){
		EmailConfiguration emailConfiguration = modelMapper.map(emailConfigurationDto, EmailConfiguration.class);
		return ResponseUtil.getCreatedResponse(emailConfigurationDao.createConfig(emailConfiguration));
	}

	@Override
	public ResponseEntity<ApiResponse> updateField(String action, boolean updateField){
		EmailConfiguration emailConfiguration = emailConfigurationDao.getConfig(action).orElseThrow(() -> new RuntimeException(action + " is not found"));
		emailConfiguration.setEnabled(updateField);
		emailConfiguration = emailConfigurationDao.update(emailConfiguration);
		return ResponseUtil.getOkResponse(emailConfiguration);
	}
	
	@Override
	public ResponseEntity<ApiResponse> updateEmailTemplate(EmailTemplate emailTemplate, String action){
		
		EmailConfiguration emailConfiguration = emailConfigurationDao.getConfig(action).orElseThrow(() -> new RuntimeException(action + " is not found"));
		if (!StringUtils.isEmpty(emailTemplate.getSubject()) && !StringUtils.isEmpty(emailTemplate.getBody())) {
			emailConfiguration.setSubject(emailTemplate.getSubject());
			emailConfiguration.setBody(emailTemplate.getBody());
			emailConfiguration.setTemplate(emailTemplateService.processEmailTemplate(emailTemplate));
			return ResponseUtil.getOkResponse(emailConfiguration);
		}
		emailTemplate.setSubject(emailConfiguration.getSubject());
		emailTemplate.setBody(emailConfiguration.getBody());
		emailConfiguration.setTemplate(emailTemplateService.processEmailTemplate(emailTemplate));
		return ResponseUtil.getOkResponse(emailConfiguration);
		
	}

	@Override
	public ResponseEntity<ApiResponse> getTemplateStatus() {
		List<EmailConfiguration> configs = emailConfigurationDao.getAll();
		List<StatusTemplate> statusTemplates = new ArrayList();
		for(EmailConfiguration config : configs) {
			StatusTemplate temp = modelMapper.map(config, StatusTemplate.class);
			statusTemplates.add(temp);
		}
		return ResponseUtil.getOkResponse(statusTemplates);
	}

	@Override
	public ResponseEntity<ApiResponse> getConfigStatus(String action){
		EmailConfiguration emailConfiguration = emailConfigurationDao.getConfig(action).orElseThrow(() -> new RuntimeException(action + " is not found"));
		StatusTemplate temp = modelMapper.map(emailConfiguration, StatusTemplate.class);
		return ResponseUtil.getOkResponse(temp);
	}

}
