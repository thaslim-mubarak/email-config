//package com.emailConfiguration.controller;
//
//import com.emailConfiguration.dto.ApiResponse;
//import com.emailConfiguration.dto.EmailTemplate;
//import com.emailConfiguration.service.impl.MailSenderImpl;
//import com.emailConfiguration.util.ResponseUtil;
//import jakarta.validation.constraints.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class MailSendController {
//
//    @Autowired
//    private MailSenderImpl mailSender;
////    @PostMapping("/send")
////    public ResponseEntity<ApiResponse> sendMail(@RequestParam String action, @RequestHeader String to, @RequestBody @NotNull EmailTemplate emailTemplate){
////        mailSender.sendEmail(action, to, emailTemplate);
////        return ResponseUtil.getOkResponse(emailTemplate);
////    }
//
//}
