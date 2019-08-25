package com.lxy.lambdademo.model;

/**
 * @author liuxinyun
 * @date 2019/8/25 13:42
 */
public class Student {

    /**
     * 姓名
     */
    private String name;

    /**
     * 成绩
     */
    private double grade;

    public Student() {
    }

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
