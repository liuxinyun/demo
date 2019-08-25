package com.lxy.lambdademo.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuxinyun
 * @date 2019/8/25 13:22
 */
public class String2Integer {

    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        List<Integer> integerList = Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        integerList.forEach(System.out::println);
    }
}
