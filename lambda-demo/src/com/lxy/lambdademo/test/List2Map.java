package com.lxy.lambdademo.test;

import com.lxy.lambdademo.model.Employee;
import com.lxy.lambdademo.util.CommonUtil;
import com.lxy.lambdademo.model.LearningSchedule;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author 刘新运
 * @date 2019/7/9 17:03
 */
public class List2Map {

    public static void main(String[] args) {

        List<Employee> employeeList = CommonUtil.getEmployeeList();
        // 按部门分组
        Map<String, List<Employee>> byDepart = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        byDepart.forEach((k, v) -> System.out.println(k+":"+v.toString()));
        // 按部门分组并汇总薪水
        Map<String, Double> byDepartSum = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        byDepartSum.forEach((k, v) -> System.out.println(k+":"+v.toString()));
        Map<String, BigDecimal> byDepartSumBigDecimal = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(e -> BigDecimal.valueOf(e.getSalary()), Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        byDepartSumBigDecimal.forEach((k, v) -> System.out.println(k+":"+v.toString()));
        // 按部门分组并取每个部门薪水最大的员工
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> dapartMaxMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(bySalary))));
        dapartMaxMap.forEach((k, v) -> v.ifPresent(employee -> System.out.println(k + ":" + employee.toString())));

        List<LearningSchedule> scheduleList = CommonUtil.getScheduleList();

        /*
         *  普通的分组
         * userId为key, 本身为value
         */
        Map<Integer, LearningSchedule> userIdMap = scheduleList.stream().collect(Collectors.toMap(LearningSchedule::getUserId, o -> o, (k1, k2) -> k1));
        userIdMap.forEach((k, v) -> System.out.println(k+":"+v.toString()));

        /*
         *  取两个属性拼接作为key，并取另一个属性的集合
         * courseId_learningSubjectId为key,nodeId Set为value
         */
        Map<String, Set<Integer>> courseIdSubjectIdAndNodesMap = scheduleList.stream().collect(Collectors.groupingBy(s -> s.getCourseId() + "_" + s.getLearningSubjectId(),
                Collectors.mapping(LearningSchedule::getLcNodeId, Collectors.toSet())));
        courseIdSubjectIdAndNodesMap.forEach((k, v) -> System.out.println(k+":"+v.toString()));

        // 大集合拍平
        List<Integer> flapList = courseIdSubjectIdAndNodesMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(flapList);
    }
}
