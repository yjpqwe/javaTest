package com.java.test.abstarct_interface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 程序员的基本工作
 */
public interface IBaseWorking {
    void baseCoding();

    void baseTesting();

    default void config(){
        System.out.println("BaseWorking For Config");
    }

    static void time(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
}
