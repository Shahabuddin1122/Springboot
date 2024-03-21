package com.dsi.database.service.implententation;

import com.dsi.database.config.TwilioConfig;
import com.dsi.database.dao.SmsDao;
import com.dsi.database.dao.SmsResponseDao;
import com.dsi.database.service.TwilioService;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;

import java.text.DecimalFormat;
import java.util.Random;

@Service
public class TwilioServiceImpl implements TwilioService {

    @Autowired
    private TwilioConfig twilioConfig;

    @Override
    public ResponseEntity<?> SendSMS(String number) {
        SmsResponseDao smsResponseDao = null;

        try {

            String ReceiverNumber;
            if (!number.startsWith("+88")) {
                ReceiverNumber = "+88"+number;
            } else {
                ReceiverNumber = number;
            }

            PhoneNumber to = new PhoneNumber(ReceiverNumber);
            PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber());
            String otp = generateOtp();

            String otpMessage = "Dear Customer , Your Ekhonni Verification code is - "+otp;

            Message message = Message
                    .creator(to,from,otpMessage)
                    .create();
            System.out.println(message.getSid());
            return new ResponseEntity<>(message.getSid(), HttpStatus.GONE);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error to send", HttpStatus.BAD_REQUEST);
        }
    }

    private String generateOtp(){
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
}
