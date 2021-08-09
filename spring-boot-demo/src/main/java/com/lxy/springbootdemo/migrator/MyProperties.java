package com.lxy.springbootdemo.migrator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 测试配置迁移
 *
 * @author liuxinyun
 * @date 2021/8/8 22:59
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "my")
public class MyProperties {

    private String name;

    private App app;

    @Data
    public static class App {
        private String name;
    }

}
