package com.matheuswegner.springemailservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuswegner.springemailservice.adapters.MailSenderGateway;
import com.matheuswegner.springemailservice.core.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase{
    
    
    private final MailSenderGateway mailSenderGateway;
    
    @Autowired
    public EmailSenderService(MailSenderGateway mailSenderGateway){
        this.mailSenderGateway = mailSenderGateway;
    }

    @Override
    public void sendMail(String to, String subject, String body) {
        this.mailSenderGateway.sendMail(to, subject, body);
    }
}
