package com.johnlu.exercise.loadedclass;

import com.johnlu.exercise.test.memory.Boy;

/**
 * @author lxp
 * @date 2019/8/7 上午11:06
 * @Version 1.0
 */
public class LoadedClassTest {
    private Boy boy;

    public static void main(String[] args) {
        Class<ClassLoader> clazz = ClassLoader.class;
        System.out.println(clazz.getName());
        Class<?>[] list = clazz.getClasses();
        ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
        tl.set(10);
        if (list.length > 0) {
            for (Class c : list) {
                System.out.println(c.getName());
            }
        } else {
            System.out.println("zero classes");
        }
    }
}
