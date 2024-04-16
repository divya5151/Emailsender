package com.mail.server.controllers;

import com.mail.server.entities.BulkEmail;
import com.mail.server.entities.Email;
import com.mail.server.services.impl.EmailServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Email")
public class EmailController {
    @Autowired
    EmailServiceImpl Emimpl;
    @PostMapping("/sendmail")
    public  void send(@RequestBody Email e){
        Emimpl.sendEmail(e.getTo(),e.getSubject(),e.getMessage());
    }
    @PostMapping("/sendbulk")
    public  void sendbulk(@RequestBody BulkEmail e){
        Emimpl.bulkEmails(e.getTo(),e.getSubject(),e.getMessage());
    }
    @PostMapping("/sendhtml")
    public  void sendhtml(@RequestBody Email e) throws MessagingException {
        Emimpl.sendHtmlEmail(e.getTo(), e.getSubject(),e.getMessage());
    }
}
