package com.java.test;

import java.math.BigDecimal;

/**
 * 数值计算和时间计算
 */
@SuppressWarnings("all")
public class NumberAndTime {
    /**
     * scale需要与小数位进行匹配
     */
    private static void scaleProblem(){
        BigDecimal decimal= new BigDecimal("12.222");
        /**
         * 指定了精度为2，执行会精度报错
         */
//        BigDecimal result = decimal.setScale(2);
//        System.out.println(result);
        /**
         * 指定精度大了，可以正常运行
         */
//        BigDecimal result1 = decimal.setScale(12);
//        System.out.println(result1);

        BigDecimal result2 = decimal.setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
        System.out.println(result2);
    }

    /**
     * BigDecimal 做除法时出现除不尽的情况
     */
    private static void divideProblem(){
//        System.out.println(new BigDecimal(30).divide(new BigDecimal(7)));
        System.out.println(new BigDecimal(30).divide(new BigDecimal(7),2,BigDecimal.ROUND_HALF_UP)//四舍五入，保留两位有效数字
        );
    }

    /**
     * 精度问题导致比较结果和预期的不一致
     */
    private static void equalProblem(){
        /**
         * 为什么equals返回false
         * if (scale != xDec.scale)
         *             return false;
         *             查看equals源码发现有精度比较
         */
        BigDecimal bd1 = new BigDecimal("0");
        BigDecimal bd2 = new BigDecimal("0.0");

        System.out.println(bd1.equals(bd2));
        System.out.println(bd1.compareTo(bd2) == 0);

    }
    public static void main(String[] args) {
//        scaleProblem();
//        divideProblem();
        equalProblem();
    }
}
