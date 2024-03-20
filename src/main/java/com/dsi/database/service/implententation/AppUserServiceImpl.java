package com.dsi.database.service.implententation;

import com.dsi.database.model.AppUser;
import com.dsi.database.projection.AppUserView;
import com.dsi.database.projection.LoginView;
import com.dsi.database.repository.AppUserRepository;
import com.dsi.database.service.AppUserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.dsi.database.service.JwtTokenService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;


    private String baseURL = "http://localhost:8080";


    @Override
    public AppUserView registerAppUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_USER");
        AppUser savedAppUser = appUserRepository.save(appUser);
        return new SpelAwareProxyProjectionFactory().createProjection(AppUserView.class, savedAppUser);
    }

    @Override
    public ResponseEntity<?> loginAppUser(String email, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
            authenticationManager.authenticate(authenticationToken);
            String jwtToken = jwtTokenService.createToken(email);
            AppUser appUser = appUserRepository.findByEmail(email);
            LoginView loginView = new SpelAwareProxyProjectionFactory().createProjection(LoginView.class, appUser);
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("user", loginView);
            responseBody.put("token", jwtToken);
            return ResponseEntity.ok(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(Map.of("error", "bad credential"), HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<?> fetchAll() {
        List<AppUser> appUser = appUserRepository.findAll();
        return new ResponseEntity<>(appUser,HttpStatus.OK);
    }


}
