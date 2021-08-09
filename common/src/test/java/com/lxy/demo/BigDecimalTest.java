package com.lxy.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 刘新运
 * @date 2021/6/11 9:57
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;
        System.out.println(zero);
        System.out.println(zero.doubleValue() == 0);

        BigDecimal dSum = zero.add(new BigDecimal(0.1d));
        System.out.println(dSum);// 0.1
        System.out.println(dSum.doubleValue() == 0.1);// true

        double d = 0.1d;

        BigDecimal sSum = zero.add(new BigDecimal("0.1"));
        System.out.println(sSum);// 0.1
        System.out.println(sSum.doubleValue() == 0.1);

        BigDecimal one = BigDecimal.ONE;
        //System.out.println(one.divide(new BigDecimal(3)));// 0.33

        System.out.println(one.divide(new BigDecimal(3), 2, RoundingMode.FLOOR));

        BigDecimal a = new BigDecimal("0.51");



    }

}
