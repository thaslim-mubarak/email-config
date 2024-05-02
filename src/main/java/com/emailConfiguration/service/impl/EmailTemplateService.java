package com.emailConfiguration.service.impl;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.emailConfiguration.dto.EmailTemplate;

@Service
public class EmailTemplateService {

    private final TemplateEngine templateEngine;
    
    public EmailTemplateService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String processEmailTemplate(EmailTemplate emailTemplate) {
        Context context = new Context();
        context.setVariable("subject", emailTemplate.getSubject());
        context.setVariable("body", emailTemplate.getBody());
        return templateEngine.process("template", context);
    }
}

