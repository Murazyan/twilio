package com.example.twilio;

import com.twilio.Twilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@SpringBootApplication
public class TwilioApplication {


    public static final String ACCOUNT_SID =
            "AC02214bfa32cda9c2e2bfdbaa82cbeb61";
    public static final String AUTH_TOKEN =
            "8443aa246bd2d09fecdb3bdbf10bf196";

    public static void main(String[] args) {
        SpringApplication.run(TwilioApplication.class, args);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator(new PhoneNumber("+37493195104"),
                        new PhoneNumber("++12565008192"),
                        "Barev Lilit jan").create();

                System.out.println(message.getSid());
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }
}



