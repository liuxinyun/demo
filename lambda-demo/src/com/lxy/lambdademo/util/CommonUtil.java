package com.lxy.lambdademo.util;

import com.lxy.lambdademo.model.Employee;
import com.lxy.lambdademo.model.LearningSchedule;
import com.lxy.lambdademo.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxinyun
 * @date 2019/7/11 23:19
 */
public class CommonUtil {

    private static List<LearningSchedule> scheduleList;

    private static List<Student> studentList;

    private static List<Employee> employeeList;

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

        studentList = new ArrayList<>();
        studentList.add(new Student("刘小杰", 78));
        studentList.add(new Student("秦大运", 59));
        studentList.add(new Student("新之云", 100));
        studentList.add(new Student("文木水", 99));

        employeeList = new ArrayList<>();
        employeeList.add(new Employee("刘小杰", "法务部", 99999));
        employeeList.add(new Employee("秦大运", "财务部", 88888));
        employeeList.add(new Employee("新之云", "法务部", 77777));
        employeeList.add(new Employee("文木水", "财务部", 66666));

    }

    public static synchronized List<LearningSchedule> getScheduleList() {
        return scheduleList;
    }

    public static synchronized List<Student> getStudentList() {
        return studentList;
    }

    public static synchronized List<Employee> getEmployeeList() {
        return employeeList;
    }
}
