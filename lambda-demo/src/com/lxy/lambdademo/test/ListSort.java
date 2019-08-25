package com.lxy.lambdademo.test;

import com.lxy.lambdademo.util.CommonUtil;
import com.lxy.lambdademo.model.LearningSchedule;

import java.util.Comparator;
import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/7/11 22:51
 */
public class ListSort {

    public static void main(String[] args) {
        List<LearningSchedule> scheduleList = CommonUtil.getScheduleList();

        System.out.println("根据用户id排序，默认升序");
        scheduleList.sort(Comparator.comparing(LearningSchedule::getUserId));
        scheduleList.forEach(s -> System.out.print(s.getUserId()+","));
        System.out.println();
        System.out.println("根据用户id排序，逆序");
        scheduleList.sort(Comparator.comparing(LearningSchedule::getUserId).reversed());
        scheduleList.forEach(s -> System.out.print(s.getUserId()+","));
        System.out.println();

        // 通过thenComparing来构造链式排序
        System.out.println("根据用户id和课程id升序");
        scheduleList.sort(Comparator.comparing(LearningSchedule::getUserId)
                .thenComparing(LearningSchedule::getCourseId));
        scheduleList.forEach(System.out::println);
        System.out.println("根据用户id逆序和课程升序");
        scheduleList.sort(Comparator.comparing(LearningSchedule::getUserId).reversed()
                .thenComparing(LearningSchedule::getCourseId));
        scheduleList.forEach(System.out::println);
    }

}
