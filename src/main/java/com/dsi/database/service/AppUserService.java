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

    ResponseEntity<?> updateProfile(String token, AppUser appUser);

    AppUser fetchInformation(String token);

    AppUser findUser(String email);

    void generateLink(String email) throws MessagingException;

    ResponseEntity<?> validateToken(String token);

    AppUser addAdmin(AppUser appUser);

    AppUser deleteAdmin(String email);

    ResponseEntity<?> fetchOtherAdmins(String email);

//    ResponseEntity<?> deleteAccount(AppUser appUser);

    ResponseEntity<?> resetPassword(String email, String password);
}

