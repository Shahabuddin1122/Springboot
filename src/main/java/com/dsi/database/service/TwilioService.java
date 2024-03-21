package com.dsi.database.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TwilioService {
    ResponseEntity<?> SendSMS(String number);
}
