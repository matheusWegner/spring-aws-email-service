package com.matheuswegner.springemailservice.core;

public interface EmailSenderUseCase {
    void sendMail (String to,String subject,String body);
}
