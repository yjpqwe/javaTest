package com.java.test;

import java.util.*;

public class EqualOrElse {
    public static class User implements Comparable<User>{
        private String name;
        private Integer age;

        public User(){}

        public User(String name,Integer age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj){
            if(obj instanceof User){
                User user = (User)obj;
                return this.name.equals(user.name) && this.age == user.age;
            }return false;

        }

        @Override
        public int compareTo(User o) {
            return (this.age - o.age) + this.name.compareTo(o.name) ;
        }
    }

    /**
     * 实现/不实现equals方法和hashcode对于判等的影响
     */
    private static void equalsAndHashcode(){
        User user1 = new User("uoyi",12);
        User user2 = new User("uoyi",12);

        System.out.println(user1.equals(user2));

        Set<User> userSet = new HashSet<>();
        userSet.add(user1);
        userSet.add(user2);
        //set判断是否为同一对象，判断的是hashcode

        Map<User,Integer> userIntegerMap = new HashMap<>();
        userIntegerMap.put(user1,0);
        userIntegerMap.put(user2,0);

        System.out.println(userSet.size());
        System.out.println(userIntegerMap.size());
    }

    /**
     * 集合元素索引与equals方法相关
     * @param args
     */
    private static void compareToAndEquals(){
        List<User> users = new ArrayList<>();
        users.add(new User("uoyi",10));
        users.add(new User("uoyi",20));

        User user = new User("uoyi",20);

        int index1 = users.indexOf(user);
        int index2 = Collections.binarySearch(users,user);

        System.out.println(index1);
        System.out.println(index2);
    }
    public static void main(String[] args) {
//        equalsAndHashcode();

        compareToAndEquals();
    }
}
