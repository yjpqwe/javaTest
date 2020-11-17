package com.java.test;

import com.google.common.base.Enums;

import java.util.*;

/**
 * 编码中常见的异常
 */
@SuppressWarnings("all")
public class GeneralException {
    public  static class User{
        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    private static void concurrentModificationException(ArrayList<User> users){
        /*
        快速失败机制，互斥锁
         */
        /**
         * 直接使用for循环会触发并发修改异常
         */
//        for (User user : users) {
//            if(user.getName().equals("imooc")){
//                users.remove(user);
//            }
//        }

        //可以使用迭代器完成操作
        /**
         * 必须要注意的是，next方法要在remove方法调用之前调用
         * 调用remove 再调用next方法会报异常，与上面报的异常一致。产生的原因也一致
         */
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()){
            User user = iter.next();
            if (user.getName().equals("imooc")){
                iter.remove();
            }
        }
        /**
         * 还有更好的操作，就是利用java8 stream实现流的过滤 还不是删除
         */
    }

    public static void main(String[] args) {
        //1.并发修改异常
//        ArrayList<User> users = new ArrayList<>(
//                Arrays.asList(new User("qinyi"),new User("imooc"))
//        );
//        ArrayList<User> users1 = (ArrayList<User>) Arrays.asList(new User("aiqiyi"), new User("imooc"));

//        concurrentModificationException(users);
        //2.类型转换异常
        User user1 = new Manager();
        User user2 = new Worker();
        Manager m1 = (Manager) user1;
//        Manager m2 = (Manager) user2; //抛出类型转换的错误 忽略本身真正的子类型

        //假如没有看到后面，就是你无法确定要转换的类型 有两种方式可以处理

        //通过getClass().getName()得到具体的类型
        System.out.println(user2.getClass().getName());
        System.out.println(user2 instanceof Manager);//比较类型

        //3.枚举查找异常
        System.out.println(enumFind("RD"));
        System.out.println(enumFind("abc"));
        //如何解决，
        //最简单和最普通的实现 利用try-catch

    }


    public static class Manager extends User{}

    public static class Worker extends User{}

    public static final Map<String,StaffType> typeIndex = new HashMap<>(
            StaffType.values().length
    );
    static{
        for (StaffType value : StaffType.values()) {
            typeIndex.put(value.name(),value);
        }
    }
    public static StaffType enumFind(String type){
        //如何解决，
        //1.最简单和最普通的实现 利用try-catch
//        try {
//            return StaffType.valueOf(type);
//        } catch (IllegalArgumentException ex){
//            return null;
//        }
        //2.改进的实现,但是效率不高，每次执行都要来一遍全量的for循环
//        for (StaffType value : StaffType.values()){
//            if (value.name().equals(type)){
//                return value;
//            }
//        }
//        return null;

        //3.利用静态的map索引,只有一次循环枚举的过程  缺点：如果它是null的话，还可能抛出空指针异常
//        return typeIndex.get(type);

        //4.第四种实现需要依赖一个包 使用google guava enums  枚举查找异常
        return Enums.getIfPresent(StaffType.class,type).orNull();
    }
}
