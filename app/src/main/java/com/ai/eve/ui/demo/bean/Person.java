package com.ai.eve.ui.demo.bean;

import java.io.Serializable;

/**
 * Created by huangfu on 2016/8/26 17.:51
 */
public class Person implements Serializable{

    private String name1;
    private String name2;
    private int age;



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name1"+name1+"name2"+name2;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
