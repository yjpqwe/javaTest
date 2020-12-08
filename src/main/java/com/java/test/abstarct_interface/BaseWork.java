package com.java.test.abstarct_interface;

/**
 * 每一个Worker 最基本的属性
 */
public abstract class BaseWork {
    /*起床时间的字段*/
    protected int wakeupTime = 8;
    //上班打卡
    protected abstract void clockIn();
    //下班打卡
    protected abstract void clockOut();

}
