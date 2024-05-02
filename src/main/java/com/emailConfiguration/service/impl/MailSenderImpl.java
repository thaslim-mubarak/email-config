//package com.emailConfiguration.service.impl;
//
//import com.emailConfiguration.dto.EmailTemplate;
//import com.emailConfiguration.entity.EmailConfiguration;
//import com.emailConfiguration.repository.EmailConfigurationRepositoy;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.TemplateEngine;
//
//import javax.mail.MessagingException;
//import javax.naming.Context;
//
//@Service
//public class MailSenderImpl {
//    @Autowired
////    private JavaMailSender mailSender;
////
////    @Autowired
////    private EmailConfigurationRepositoy emailConfigurationRepositoy;
//
////    private EmailTemplate composeEmail(BD bd) {
////        var emailTemplate = emailTemplateRepository.findByEmailType(EmailType.ACTIVATION);
////        var message = emailTemplate.getTemplate();
////        var token = createConfirmToken(bd);
////        log.info(env.getProperty(STRING_APP_NAME));
////        emailTemplate.setTemplate(message.replace("<span th:text=\"${app.name}\" />", Objects.requireNonNull(env.getProperty(STRING_APP_NAME)))
////                .replace("<span th:text=\"${name}\" />", bd.getName())
////                .replace("<a th:href=\"${password_reset}\">\"Activation Link\"</a>", "<a href=" + env.getProperty("app.set_password") + "/" +token + ">\"Activation Link\"</a>")
////                .replace("<a th:href=\"${contactUs}\">Contact Us</a>", "<a href=" + env.getProperty("app.contact") + ">Contact Us </a>"));
////        return emailTemplate;
////    }
////
////
////    public String sendActivationEmail (String toEmail, String subject, String body) {
////        SimpleMailMessage message = new SimpleMailMessage();
////
////        message.setFrom("debashsiganguly321@gmail.com");
////        message.setTo(toEmail);
////        message.setText(body);
////        message.setSubject(subject);
////
////        mailSender.send(message);
////
////        return "Activation mail sent";
////    }
//
////    public EmailTemplate sendEmail(String action, String to, EmailTemplate emailTemplate){
////        var emailConfig = emailConfigurationRepositoy.findByAction(action).orElseThrow(() -> new RuntimeException(action + " is not found"));
////        String template = emailConfig.getTemplate();
////
////        template.replace("<span th:text=\"${subject}\">", emailTemplate.getSubject())
////                .replace("<p th:text=\"${body}\">", emailTemplate.getBody());
////
////        SimpleMailMessage msg = new SimpleMailMessage();
////
////        msg.setFrom("debashsiganguly321@gmail.com");
////        msg.setTo(to);
////        msg.setText(template);
////        msg.setSubject(emailTemplate.getSubject());
////
////        mailSender.send(msg);
////
////        return emailTemplate;
////    }
//
//
//    private final JavaMailSender javaMailSender;
//    private final TemplateEngine templateEngine;
//
//    public MailSenderImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
//        this.javaMailSender = javaMailSender;
//        this.templateEngine = templateEngine;
//    }
//
//    public void sendEmail(String to, String subject, String templateName, Context context) throws MessagingException {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//        helper.setTo(to);
//        helper.setSubject(subject);
//
//        String htmlContent = templateEngine.process(templateName, context);
//        helper.setText(htmlContent, true);
//
//        javaMailSender.send(mimeMessage);
//    }
//}
