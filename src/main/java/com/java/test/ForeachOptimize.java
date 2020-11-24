package com.java.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * for循环与几何
 */
public class ForeachOptimize {
    private static Collection<Integer> left = Arrays.asList(1,2,3,4,5,6,7);
    private static Collection<Integer> right = Arrays.asList(1,2,3,4,5);

    /**
     * 集合迭代经常犯的错误
     */
    private static void wrongIterator(){
        //传统方式 使用索引
        int[] xyz = new int[]{1,2,3,4,5};
//        for (int i = 0;i!=xyz.length;++i){
//            System.out.println(xyz[i]);
//        }
//
//        //传统方式 使用迭代器
//        for(Iterator<Integer> i = left.iterator();i.hasNext();){
//            System.out.println(i.next());
//        }

        //嵌套迭代容器出现问题
        for (Iterator<Integer> l = left.iterator();l.hasNext();){
            for (Iterator<Integer> r = right.iterator();r.hasNext();){
                System.out.println(l.next() * r.next());
            }
        }

        //正确的用法，嵌套迭代
    }

    public static void main(String[] args) {
        wrongIterator();
    }
}
