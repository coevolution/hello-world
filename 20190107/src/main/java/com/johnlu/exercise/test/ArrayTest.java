package com.johnlu.exercise.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lxp
 * @date 2019/8/24 下午2:54
 * @Version 1.0
 */
public class ArrayTest {
    public static void main(String[] s) {
        int[] x = {10};
        Object array = Array.newInstance(int.class, x);
        List list = new ArrayList();
        list.add("123");
        list.add(new Man());
        list.add(55555);

        for (Object person : list) {
            System.out.println(person);
        }

    }
}
