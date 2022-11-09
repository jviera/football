package net.vieracode.football.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    private final String message = "Hello!";

    /**
     * Here you can configurate any bean which you'd use.
     * @return
     */
    @Bean(name = "sayhello")
    public String sayhello() {
        System.out.println(message);
        return message;
    }
}
