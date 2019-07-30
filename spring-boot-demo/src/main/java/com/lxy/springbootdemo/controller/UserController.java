package com.lxy.springbootdemo.controller;

import com.lxy.demo.common.ResultData;
import com.lxy.springbootdemo.model.UserEntity;
import com.lxy.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/7/30 23:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResultData queryByLikeName(String name) {
        List<UserEntity> userEntities = userService.queryLikeByName(name);
        if (userEntities.isEmpty()) {
            return ResultData.failed("对不起，未查询到用户");
        }
        return ResultData.successed(userEntities);
    }

}
