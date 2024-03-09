package com.matheuswegner.springemailservice.core;

public record EmailRequest(String to ,String subject,String body) {
    
}
