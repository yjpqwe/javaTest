package com.java.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串、数组、集合在使用时出现空指针
 *
 *
 */
public class BasicUsageNpe {

    private static boolean stringEquals(String x,String y){
        return x.equals(y);
    }

    public static class User{
        private String name;
    }

    public static void main(String[] args) {
        //equals方法可以接收null对象 java中比较string类型，不适用=符号，使用equals
//        System.out.println(stringEquals("xyz",null));
        //保证调用equals方法的对象不为空
//        System.out.println(stringEquals(null,"xyz"));
        //2、对象数组new出来，但是元素没有初始化
//        User[] users = new User[10];
//        for(User user : users){
//
//            int i = 0;
//            i++;
//            users[i] = new User();
//            users[i].name = "iam" + i;
//        }

        //3.List对象addAll 传递null会抛出空指针
        List<User> users = new ArrayList<>();
        User user = null;
        List<User> user_s = null;

        users.add(user);
        users.addAll(user_s);
/**
 * addAll源码  传入c c.toArray 因为c传入了null
 *     public boolean addAll(Collection<? extends E> c) {
 *         Object[] a = c.toArray();
 *         int numNew = a.length;
 *         ensureCapacityInternal(size + numNew);  // Increments modCount
 *         System.arraycopy(a, 0, elementData, size, numNew);
 *         size += numNew;
 *         return numNew != 0;
 *     }
 */
    }
}
