package com.java.test.function_interface_lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda 表达式的使用
 *
 */
public class StudyLambda {
    /**
     * java 1.8 之前创建线程
     */
    private static void baseUse(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class Thread run()");
            }
        }).start();
    }

    /**
     * java8 创建线程
     */
    private static void easyUseLambda(){
        new Thread(() -> System.out.println("Anonymous Class Thread run()")).start();
    }

    /**
     * 按照字符串长度进行排序
     */
    private static void myCompare(){
        //java8之前
        List<String> list = Arrays.asList("1","2","3");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1==null)
                    return -1;
                if (o2==null)
                    return 1;
                return o1.length()-o2.length();
            }
        });

        //java8 之后
        Collections.sort(list,(o1,o2)->{
            if (o1==null)
                return -1;
            if (o2==null)
                return 1;
            return o1.length()-o2.length();
        });
    }
}
