package com.dsi.database.controller;

import com.dsi.database.model.AppUser;
import com.dsi.database.service.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smtp")
public class SmtpController {
    @Autowired
    public SmtpService smtpService;

    @PostMapping
    public int sendMessage(@RequestBody AppUser appUser){
        return smtpService.sendMessage(appUser.getEmail());
    }
}
