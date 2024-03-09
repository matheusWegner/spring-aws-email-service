package com.matheuswegner.springemailservice.adapters;

public interface MailSenderGateway {
    void sendMail(String to , String subject , String body);
}
