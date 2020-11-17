package com.java.test;

import java.util.Optional;

/**
 * 学会optional，规避空指针异常
 */
public class OptionalUsage {
    public static class User{
        private String name;

        public String getName(){
            return name;
        }
    }

    private static void isUserEqualNull(){
        User user = null;

        if (user!=null){
            System.out.println("User is not null");
        }else {
            System.out.println("User is null");
        }
        //可以看到上下两个使用起来几乎一样，如果仅仅这样使用optional，没有区别，意义不大
        Optional<User> optional = Optional.empty();
        if (optional.isPresent()){
            System.out.println("User is not null");
        }else {
            System.out.println("User is null");
        }
    }

    private static User anoymos(){
        return new User();
    }
    public static void main(String[] args) {
        //没有意义的使用方法
        isUserEqualNull();

        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);//如果对象为空，就返回一个空的optional实例。如果不为空，返回一个带有user的实例
        //存在即返回，空则提供默认值  如果为空，则返回new User
        optionalUser.orElse(new User());
        //存在即返回，空则由函数去产生  比上面的方法更灵活
        optionalUser.orElseGet(()-> anoymos());
        //存在即返回，否则抛出异常
        optionalUser.orElseThrow(RuntimeException::new);

        //存在才去做相应的处理
        optionalUser.ifPresent(u-> System.out.println(u.getName())); //如果存在作操作

        //map 可以对Optional中的对象执行某种操作，且会返回一个Optional对象
        optionalUser.map(u->u.getName()).orElse("anymos");

        //map 是可以无限级联操作的
        optionalUser.map(u->u.getName()).map(name -> name.length()).orElse(0);//第一个返回的是string ，第二个返回的int 如果为空，则返回个int 即0

        //get，ifPresent这样的方法不要直接去使用，因为这些不是私有的
    }
}
