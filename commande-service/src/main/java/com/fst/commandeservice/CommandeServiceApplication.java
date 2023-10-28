package com.fst.commandeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients // to enable feign client
public class CommandeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandeServiceApplication.class, args);
    }

}
