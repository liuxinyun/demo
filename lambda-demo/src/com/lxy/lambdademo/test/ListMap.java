package com.lxy.lambdademo.test;

import com.lxy.lambdademo.util.CommonUtil;
import com.lxy.lambdademo.model.LearningSchedule;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对列表中的每个元素操作
 *
 * @author liuxinyun
 * @date 2019/7/11 23:29
 */
public class ListMap {

    public static void main(String[] args) {
        List<LearningSchedule> scheduleList = CommonUtil.getScheduleList();

        // 取用户id列表并去重
        List<Integer> userIds = scheduleList.stream().map(LearningSchedule::getUserId).distinct().collect(Collectors.toList());
        userIds.forEach(System.out::println);

        // 统计
        DoubleSummaryStatistics summaryStatistics = scheduleList.stream().mapToDouble(LearningSchedule::getScore).summaryStatistics();
        System.out.println("Max score : " + summaryStatistics.getMax());
        System.out.println("Min score : " + summaryStatistics.getMin());
        System.out.println("Sum score : " + summaryStatistics.getSum());
        System.out.println("Average : " + summaryStatistics.getAverage());
        System.out.println("Count : " + summaryStatistics.getCount());
    }
}
