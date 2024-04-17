package com.mail.server.controllers;

import com.mail.server.entities.BulkEmail;
import com.mail.server.entities.Email;
import com.mail.server.entities.Otp;
import com.mail.server.services.impl.EmailServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/sendotp/{email}")
    public  boolean sendotp(@PathVariable String email){

       return Emimpl.sendOtp(email);
    }
    @PostMapping("/verify")
    public  boolean send(@RequestBody Otp o){

        return Emimpl.verifyOtp(o.getOtp1());
    }

}
