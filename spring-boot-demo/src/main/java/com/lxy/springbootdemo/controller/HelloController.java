package com.lxy.springbootdemo.controller;

import com.lxy.demo.common.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘新运
 * @date 2019/7/8 20:47
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResultData get(@RequestParam(required = false) String name){
        String res = "Hello";
        if (null != name) {
            res += "," + name;
        }
        return ResultData.successed(res + "!");
    }
}
