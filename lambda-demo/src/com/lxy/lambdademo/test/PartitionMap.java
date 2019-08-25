package com.lxy.lambdademo.test;

import com.lxy.lambdademo.model.Student;
import com.lxy.lambdademo.util.CommonUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuxinyun
 * @date 2019/8/25 13:49
 */
public class PartitionMap {

    /**
     * 60分及格
     */
    private static final double PASS = 60d;

    public static void main(String[] args) {
        List<Student> studentList = CommonUtil.getStudentList();
        // 先排序后分组
        Map<Boolean, List<Student>> map = studentList.stream().sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS));
        System.out.println("通过学生：");
        map.get(true).forEach(System.out::println);

        System.out.println("未通过学生：");
        map.get(false).forEach(System.out::println);
    }
}
