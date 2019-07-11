package com.lxy.lambdademo.test;

import com.lxy.lambdademo.model.LearningSchedule;
import com.lxy.lambdademo.util.CommonUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxinyun
 * @date 2019/7/11 23:43
 */
public class String2List {

    public static void main(String[] args) {
        String str =  "hello, world!";
        List<String> aList = Arrays.asList(str.split(","));
        aList.forEach(System.out::println);

        List<String> bList = Arrays.stream(str.split(",")).map(String::toUpperCase).collect(Collectors.toList());
        bList.forEach(System.out::println);

        // 以逗号拼接
        String join = String.join(",", aList);
        System.out.println(join);
        // 需要用lambda拼接的
        List<LearningSchedule> scheduleList = CommonUtil.getScheduleList();
        String j = scheduleList.stream().map(s -> String.valueOf(s.getUserId())).collect(Collectors.joining(","));
        System.out.println(j);
    }
}
