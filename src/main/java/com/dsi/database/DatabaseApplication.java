package com.dsi.database;

import com.dsi.database.config.TwilioConfig;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties
@EnableCaching
public class DatabaseApplication {

    @Autowired
    private TwilioConfig twilioConfig;

    @PostConstruct
    public void setTwilioConfig(){
        Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
    }

    public static void main(String[] args) {

        SpringApplication.run(DatabaseApplication.class, args);
    }

}
