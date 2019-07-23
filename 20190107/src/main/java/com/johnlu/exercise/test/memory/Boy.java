package com.johnlu.exercise.test.memory;

/**
 * @author lxp
 * @date 2019/7/22 上午11:14
 * @Version 1.0
 */
public class Boy {
    private String name;
    private Integer age;
    private Girl girlFriend = new Girl();


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

    public Girl getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(Girl girlFriend) {
        this.girlFriend = girlFriend;
    }

    @Override public String toString() {
        return "Boy{" + "name='" + name + '\'' + ", age=" + age + ", girlFriend=" + girlFriend
            + '}';
    }
}
