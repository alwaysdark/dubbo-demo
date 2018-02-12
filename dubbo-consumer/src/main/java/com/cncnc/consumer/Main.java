package com.cncnc.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by Administrator on 2018/2/12.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableDubboConfiguration
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);

        ConsumerService consumerService = run.getBean(ConsumerService.class);

        System.out.println(consumerService.dubboInterface.getInterData("World!"));
    }
}
