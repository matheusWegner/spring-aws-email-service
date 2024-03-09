package com.matheuswegner.springemailservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheuswegner.springemailservice.application.EmailSenderService;
import com.matheuswegner.springemailservice.core.EmailRequest;
import com.matheuswegner.springemailservice.core.exceptions.EmailServiceException;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderService mailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService mailSenderService){
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequest mailRequest){
        try {
            this.mailSenderService.sendMail(mailRequest.to(),mailRequest.subject(),mailRequest.body());
            return ResponseEntity.ok("email sent successfuly");
        } catch (EmailServiceException e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }


    }
}
