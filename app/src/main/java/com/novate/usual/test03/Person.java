package com.novate.usual.test03;

import java.io.Serializable;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/7 8:45
 * Version 1.0
 * Params:
 * Description:    Serializable 实体类如下
 * ================================================
*/

public class Person implements Serializable {
    private static final long serialVersionUID = -7060210544600464481L;
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}