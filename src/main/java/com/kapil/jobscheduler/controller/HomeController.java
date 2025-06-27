package com.kapil.jobscheduler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
            <html>
                <body style='font-family: sans-serif; line-height: 1.5;'>
                    <h2>✅ Spring Boot Job Scheduler is running!</h2>
                    <p>Visit the <a href="/swagger-ui/index.html">Swagger UI</a> to explore the API.</p>
                </body>
            </html>
            """;
    }
}
