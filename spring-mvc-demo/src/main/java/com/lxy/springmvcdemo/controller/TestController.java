package com.lxy.springmvcdemo.controller;

import com.lxy.demo.common.ResultData;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuxinyun
 * @date 2019/7/7 19:19
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultData get(@RequestParam(required = false) String name){
        if (null == name){
            // 验证全局异常处理
            throw new RuntimeException("传入名称为空");
        }
        return ResultData.successed(name);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResultData post(@RequestBody String name){
        return ResultData.successed(name);
    }

    @RequestMapping(value = "/put/{name}", method = RequestMethod.PUT)
    public ResultData put(@PathVariable(value = "name") String name){
        return ResultData.successed(name);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResultData delete(@PathVariable Integer id){
        return ResultData.successed(id);
    }

}
