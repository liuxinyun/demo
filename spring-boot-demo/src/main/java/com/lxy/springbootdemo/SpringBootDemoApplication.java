package com.lxy.springbootdemo;

import com.lxy.springbootdemo.migrator.MyProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.lxy.springbootdemo.*"})
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        MyProperties myProperties = context.getBean(MyProperties.class);
        log.info("myProperties.name:{}", myProperties.getName());
        log.info("myProperties$app.name:{}", Optional.ofNullable(myProperties.getApp()).orElse(new MyProperties.App()).getName());
    }

}
