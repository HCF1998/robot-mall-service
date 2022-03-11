package com.h2.robotmallservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//暂时跳过security拦截
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RobotMallServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotMallServiceApplication.class, args);
    }

}
