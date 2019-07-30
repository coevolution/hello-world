package com.johnlu.exercise.test.memory;

/**
 * @author lxp
 * @date 2019/7/22 上午11:15
 * @Version 1.0
 */
public class Girl {
    private String name;
    private Integer age;
    private Boy boyFriend
        = new Boy();

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

    public Boy getBoyFriend() {
        return boyFriend;
    }

    public void setBoyFriend(Boy boyFriend) {
        this.boyFriend = boyFriend;
    }

    @Override public String toString() {
        return "Girl{" + "name='" + name + '\'' + ", age=" + age + ", boyFriend=" + boyFriend + '}';
    }
}
