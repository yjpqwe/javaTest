package com.java.test;

/**
 * java异常处理
 */
public class ExceptionProcess {

    public static class User{}

    /**
     * java异常本质 -- 抛出异常
     */
    private void throwException(){
        User user = null;
        if (null == user){
            throw new NullPointerException();
        }
    }

    /**
     * 不能捕获异常
     */
    private void canNotCatchNpeException(){
        try {
            throwException();
        }catch (ClassCastException cce){
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        }
    }

    /**
     * 能够捕获空指针异常
     */
    private void canCatchNpeException(){
        try {
            throwException();
        }catch (ClassCastException cce){
            System.out.println(cce.getMessage());
            System.out.println(cce.getClass().getName());
        }catch (NullPointerException npe){
            System.out.println(npe.getMessage());
            System.out.println(npe.getClass().getName());
        }
    }

    public static void main(String[] args) {
        ExceptionProcess process = new ExceptionProcess();
        process.canCatchNpeException();
        process.canNotCatchNpeException();
    }
}
