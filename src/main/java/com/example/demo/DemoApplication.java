package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "John") String name,
                           Model model) {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        String greetingMessage;

        if (hour < 12) {
            greetingMessage = "Good morning, " + name + ", Welcome to COMP367";
        } else {
            greetingMessage = "Good afternoon, " + name + ", Welcome to COMP367";
        }

        model.addAttribute("greeting", greetingMessage);
        return "index";
    }
}
