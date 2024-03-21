package com.dsi.database.service;

import org.springframework.stereotype.Service;

@Service
public interface SmtpService {
    int sendMessage(String email);
}
