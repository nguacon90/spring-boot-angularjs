package vn.com.nguacon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("vn.com.nguacon")
public class Application extends SpringBootServletInitializer{
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
}