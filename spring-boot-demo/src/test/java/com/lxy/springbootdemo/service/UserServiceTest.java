package com.lxy.springbootdemo.service;

import com.lxy.springbootdemo.SpringBootDemoApplicationTests;
import com.lxy.springbootdemo.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author liuxinyun
 * @date 2021/8/8 19:42
 */
public class UserServiceTest extends SpringBootDemoApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void queryLike() {
        List<UserEntity> list = userService.queryLikeByName("张三");
        System.out.println(list);
    }

}
