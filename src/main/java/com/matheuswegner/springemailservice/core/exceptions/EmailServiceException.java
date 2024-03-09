package com.matheuswegner.springemailservice.core.exceptions;

public class EmailServiceException extends RuntimeException{
    public EmailServiceException(String message){
        super(message);
    }

    public EmailServiceException(String message,Throwable throwable){
        super(message,throwable);
    }
}
