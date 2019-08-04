package com.lxy.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author liuxinyun
 * @date 2019/8/4 22:33
 */
@Configuration
@ImportResource(locations = "classpath:spring-context.xml")
public class ContextConfig {
}
