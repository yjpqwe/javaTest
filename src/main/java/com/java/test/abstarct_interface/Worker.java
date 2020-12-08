package com.java.test.abstarct_interface;

/**
 * 员工类
 */
public class Worker extends BaseWork implements IBaseWorking,IExtraWorking{
    @Override
    protected void clockIn() {

    }

    @Override
    protected void clockOut() {

    }

    @Override
    public void baseCoding() {

    }

    @Override
    public void baseTesting() {

    }

    @Override
    public void config() {
        //定义自己的config
        System.out.println();
    }

    @Override
    public void extraCoding() {

    }

    @Override
    public void extraTesting() {

    }
}
