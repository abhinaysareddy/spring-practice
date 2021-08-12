package com.example.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @EventListener(ApplicationReadyEvent.class)
    public void afterApplicationRead(){
        System.out.println("After ready");
    }
}
