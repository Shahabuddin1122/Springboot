package com.dsi.database.controller;

import com.dsi.database.dao.SmsDao;
import com.dsi.database.model.AppUser;
import com.dsi.database.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/twilio")
public class TwilioController {
    @Autowired
    public TwilioService twilioService;

    @GetMapping
    public String processSMS(){
        return "SMS sent";
    }

    @PostMapping
    public ResponseEntity<?> sendSMS(@RequestBody SmsDao smsDao){
        return twilioService.SendSMS(smsDao.getNumber());
    }
}
