package com.dsi.database.controller;

import com.dsi.database.model.AppUser;
import com.dsi.database.projection.AppUserView;
import com.dsi.database.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AppUserController {

    @Autowired
    public AppUserService appUserService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAppUser(@RequestBody AppUser appUser) {
        AppUserView registeredUser = appUserService.registerAppUser(appUser);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginAppUser(@RequestBody AppUser appUser){

        return appUserService.loginAppUser(appUser.getEmail(), appUser.getPassword());
    }



}
