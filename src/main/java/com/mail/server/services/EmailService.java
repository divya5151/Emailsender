package com.mail.server.services;

import jakarta.mail.MessagingException;

public interface EmailService {
    public void sendEmail(String to,String subject,String message);

    public void bulkEmails(String[] to,String subject,String message);

    public  void sendHtmlEmail(String to,String subject,String message) throws MessagingException;

}
