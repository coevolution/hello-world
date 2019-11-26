package com.johnlu.exercise.test;

/**
 * @author lxp
 * @date 2019/6/10 下午7:16
 * @Version 1.0
 */
public class Man implements Cloneable {
    String name;
    int age;
    boolean sex;

    public Man(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Man() {
    }

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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
