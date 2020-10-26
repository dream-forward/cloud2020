package com.athuayu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



/**
 * @author Leelay
 * @create 2020-02-18 17:20
 */
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration=MySelfRule.class)
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
