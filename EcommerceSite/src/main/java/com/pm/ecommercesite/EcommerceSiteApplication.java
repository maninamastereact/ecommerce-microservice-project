package com.pm.ecommercesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EcommerceSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceSiteApplication.class, args);
    }

}
