package com.java.test.lombok_;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * lombok工具的使用以及需要避免的坑
 *
 */
public class Main {
    /**
     * lombok第一个坑
     * 单字母驼峰  还有Jackson的学习
     */
    private static void singleAlphabetHump() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Personal personal = new Personal();
        personal.setIPhone("8.1");

        //{"name":null,"userName":null,"iphone":"8.1"} 这里会发现iphone 序列和反序列化时可能会出现不一致导致数据丢失的问题
        System.out.println(mapper.writeValueAsString(personal));

        String json = "{\"name\":\"qinyi\",\"userName\":\"qinyi-imooc\",\"iphone\":\"8.1\"}";

        Personal personal1 = mapper.readValue(json,Personal.class);
        System.out.println(personal1);

    }

    /**
     * lom
     */
    private static void equalsAndHashCodeBug(){
        AppleComputer computer1 = new AppleComputer(1,"Mac pro",1L,"yellow");
        AppleComputer computer2 = new AppleComputer(2,"Mac Air",1L,"yellow");
        System.out.println(computer1.equals(computer2));
    }
    public static void main(String[] args) throws JsonProcessingException {
//        singleAlphabetHump();
        equalsAndHashCodeBug();
    }
}
