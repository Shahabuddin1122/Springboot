package com.dsi.database.service;

import com.dsi.database.model.AppUser;
import jakarta.mail.MessagingException;
import com.dsi.database.projection.AppUserView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface AppUserService {

    AppUserView registerAppUser(AppUser appUser);

    ResponseEntity<?> loginAppUser(String email, String password);

    ResponseEntity<?> fetchAll();

}

