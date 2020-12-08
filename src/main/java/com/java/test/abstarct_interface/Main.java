package com.java.test.abstarct_interface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * java8新增的静态方法和默认方法
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5);
        int min = list.stream().min(Comparator.comparing(value -> value)).get();
        int max = list.stream().max(Comparator.comparing(value -> value)).get();

        System.out.println(min);
        System.out.println(max);

        IBaseWorking.time();
        IExtraWorking.time();
    }
}
