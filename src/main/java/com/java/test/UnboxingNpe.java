package com.java.test;

/**
 *  自动拆箱引发的空指针问题
 */
public class UnboxingNpe {
    private static int add(int x,int y){
        return x+y;
    }

    private static boolean compare(long x,long y){
        return x>=y;
    }

    public static void main(String[] args) {
        //1.变量赋值自动拆箱出现的空指针
//        Long count = null;
//        long count_ = count;
        //2.方法传参时自动拆箱引发的空指针问题
//        Integer left = null;
//        Integer right = null;
//        System.out.println(add(left,right));

        //3.用于大小比较的场景
        Long x1 = 10L;
        Long x2 = null;
        System.out.println(compare(x1,x2));

        /*
         * 探究原因
         *
         * */
    }
}

