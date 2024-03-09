package com.matheuswegner.springemailservice.infra.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.matheuswegner.springemailservice.adapters.MailSenderGateway;
import com.matheuswegner.springemailservice.core.exceptions.EmailServiceException;
@Service
public class SesMailSender implements MailSenderGateway{

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired//inejetado automaticamente pelo spring
    public SesMailSender (AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendMail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
        .withSource("math.christo@gmail.com")
        .withDestination(new Destination().withToAddresses(to))
        .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                    );
        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException e) {
            e.printStackTrace();
            throw new EmailServiceException("Failute while sending email :" + e.getMessage(),e);

        }                           
    }
    
}
