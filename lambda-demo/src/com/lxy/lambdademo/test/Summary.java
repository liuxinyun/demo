package com.lxy.lambdademo.test;

import com.lxy.lambdademo.model.Employee;
import com.lxy.lambdademo.util.CommonUtil;

import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * 对列表中的每个元素操作
 *
 * @author liuxinyun
 * @date 2019/7/11 23:29
 */
public class Summary {

    public static void main(String[] args) {
        List<Employee> employeeList = CommonUtil.getEmployeeList();

        // 统计
        DoubleSummaryStatistics summaryStatistics = employeeList.stream().mapToDouble(Employee::getSalary).summaryStatistics();
        System.out.println("Max : " + summaryStatistics.getMax());
        System.out.println("Min : " + summaryStatistics.getMin());
        System.out.println("Sum : " + summaryStatistics.getSum());
        System.out.println("Average : " + summaryStatistics.getAverage());
        System.out.println("Count : " + summaryStatistics.getCount());
    }
}
