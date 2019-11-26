package com.johnlu.exercise.test.johnfinal;

import com.johnlu.exercise.test.memory.Boy;

/**
 * @author lxp
 * @date 2019/7/23 下午5:32
 * @Version 1.0
 */
public class FinalTest {
    private static final Boy setJames(final Boy boy) {
        boy.setName("James");
        return boy;
    }

    private static final Boy setNull() {

        return null;
    }

    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.setName("John");
        Boy boy1 = setJames(boy);
        System.out.println(boy1.getName());
        boy1 = new Boy();
        boy1.setName("Tom");
        System.out.println(boy1.getName());
        System.out.println(boy.getName());
    }
}
