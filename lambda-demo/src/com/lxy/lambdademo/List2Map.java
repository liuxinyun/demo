package com.lxy.lambdademo;

import com.lxy.lambdademo.model.LearningSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 刘新运
 * @date 2019/7/9 17:03
 */
public class List2Map {

    public static void main(String[] args) {

        /*
         *  普通的分组
         * userId为key, 本身为value
         */
        Map<Integer, LearningSchedule> userIdMap = scheduleList.stream().collect(Collectors.toMap(LearningSchedule::getUserId, o -> o, (k1, k2) -> k1));
        userIdMap.forEach((k, v) -> {
            System.out.println(k+":"+v.toString());
        });

        /*
         *  取两个属性拼接作为key，并取另一个属性的集合
         * courseId_learningSubjectId为key,nodeId Set为value
         */
        Map<String, Set<Integer>> courseIdSubjectIdAndNodesMap = scheduleList.stream().collect(Collectors.groupingBy(s -> s.getCourseId() + "_" + s.getLearningSubjectId(),
                Collectors.mapping(LearningSchedule::getLcNodeId, Collectors.toSet())));
        courseIdSubjectIdAndNodesMap.forEach((k, v) -> {
            System.out.println(k+":"+v.toString());
        });
    }


    private static List<LearningSchedule> scheduleList;
    static {
        scheduleList = new ArrayList<>();
        scheduleList.add(new LearningSchedule(1, 1, 1, 1));
        scheduleList.add(new LearningSchedule(1, 1, 1, 2));
        scheduleList.add(new LearningSchedule(1, 1, 2, 1));
        scheduleList.add(new LearningSchedule(1, 2, 1, 1));
        scheduleList.add(new LearningSchedule(1, 1, 2, 2));
        scheduleList.add(new LearningSchedule(1, 2, 1, 2));
        scheduleList.add(new LearningSchedule(1, 2, 2, 1));
        scheduleList.add(new LearningSchedule(1, 2, 2, 2));
        scheduleList.add(new LearningSchedule(2, 1, 1, 1));
        scheduleList.add(new LearningSchedule(2, 1, 1, 2));
        scheduleList.add(new LearningSchedule(2, 1, 2, 1));
        scheduleList.add(new LearningSchedule(2, 2, 1, 1));
        scheduleList.add(new LearningSchedule(2, 1, 2, 2));
        scheduleList.add(new LearningSchedule(2, 2, 1, 2));
        scheduleList.add(new LearningSchedule(2, 2, 2, 1));
        scheduleList.add(new LearningSchedule(2, 2, 2, 2));
    }
}
