package com.lxy.lambdademo.util;

import com.lxy.lambdademo.model.LearningSchedule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/7/11 23:19
 */
public class CommonUtil {

    private static List<LearningSchedule> scheduleList;
    static {
        scheduleList = new ArrayList<>();
        scheduleList.add(new LearningSchedule(1, 3, 2, 1, 24d));
        scheduleList.add(new LearningSchedule(1, 1, 1, 1, 43d));
        scheduleList.add(new LearningSchedule(3, 1, 1, 2, 19d));
        scheduleList.add(new LearningSchedule(8, 2, 2, 1, 22d));
        scheduleList.add(new LearningSchedule(4, 1, 2, 2, 43d));
        scheduleList.add(new LearningSchedule(2, 6, 1, 1, 66d));
        scheduleList.add(new LearningSchedule(4, 2, 2, 2,88d));
        scheduleList.add(new LearningSchedule(10, 1, 2, 2, 99d));
        scheduleList.add(new LearningSchedule(2, 1, 1, 1, 28d));
        scheduleList.add(new LearningSchedule(6, 2, 1, 2, 52d));
        scheduleList.add(new LearningSchedule(7, 2, 2, 1, 61d));
        scheduleList.add(new LearningSchedule(5, 2, 2, 2, 32d));
    }
    public static synchronized List<LearningSchedule> getScheduleList() {
        return scheduleList;
    }
}
