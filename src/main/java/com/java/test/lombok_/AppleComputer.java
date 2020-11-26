package com.java.test.lombok_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)//是否在子类的equals方法中加入父类的判断 这是一个坑，会导致子类两个对象判等的时候有误
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppleComputer extends Computer {
    private long price;
    private String color;

    public AppleComputer(Integer id,String name,long price,String color){
        super(id,name);
        this.price = price;
        this.color = color;
    }
}
