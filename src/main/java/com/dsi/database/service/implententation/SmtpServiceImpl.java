package com.dsi.database.service.implententation;

import com.dsi.database.service.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SmtpServiceImpl implements SmtpService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final Random random = new Random();

    @Override
    public int sendMessage(String email) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sdpproject74@gmail.com");
        message.setTo(email);

        int randomValue = random.nextInt(90000)+10000;

        message.setText("Your Ekhonni Registration OTP is "+ randomValue);
        message.setSubject("Please verify your email address");
        javaMailSender.send(message);

        System.out.println("Message send successfully........");

        return randomValue;
    }
}
