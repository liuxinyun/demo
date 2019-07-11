package com.lxy.lambdademo.test;

import com.lxy.lambdademo.util.CommonUtil;
import com.lxy.lambdademo.model.LearningSchedule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 过滤满足某些条件的
 *
 * @author liuxinyun
 * @date 2019/7/11 23:18
 */
public class ListFilter {

    public static void main(String[] args) {
        List<LearningSchedule> scheduleList = CommonUtil.getScheduleList();

        // 取分数大于60且用户id为偶数的
        List<LearningSchedule> newList = scheduleList.stream().filter(s -> s.getUserId() % 2 == 0 && s.getScore().compareTo(60d) >= 0).collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

}
