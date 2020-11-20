package com.java.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

    /**
     * SimpleDateFormat
     * 可以解析大于/等于它定义的时间精度  解析更精确的时间
     * @throws Exception
     */
    private static void formatPrecision() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//注意MM是大写
        String time_x = "2020-03-01 10:00:00";
        String time = "2020-03";
        System.out.println(sdf.parse(time_x));
        System.out.println(sdf.parse(time ));
    }

    private static void threadSafety(){
        //主要是SimpleDateFormat维护一个Calendar对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,100,1,
                TimeUnit.MINUTES,new LinkedBlockingDeque<>(1000));
        while (true){
            threadPoolExecutor.execute(()->{
                String dateString ="2020-03-01 10:00:00";
                try {
                    Date parseDate = sdf.parse(dateString);
                    String dateString2 = sdf.format(parseDate);
                    System.out.println(dateString.equals(dateString2));
                }catch (ParseException ex){
                    ex.printStackTrace();
                }
            });
        }

    }
    public static void main(String[] args) throws Exception {
//        scaleProblem();
//        divideProblem();
//        equalProblem();
//        formatPrecision();
        threadSafety();
    }
}
