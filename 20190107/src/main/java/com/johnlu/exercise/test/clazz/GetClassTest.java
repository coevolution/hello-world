package com.johnlu.exercise.test.clazz;

import com.johnlu.exercise.test.singleton.Singleton1;

import java.util.Date;

/**
 * @author lxp
 * @date 2019/9/4 上午10:27
 * @Version 1.0
 */
public class GetClassTest extends Singleton1 {

    public static void main(String[] a) {
        new GetClassTest().test();
    }

    private void test() {
        int count = 0;
        ok:
        for (int i = 0; i < 10; i++) {
            count++;
            for (int j = 0; j < 5; j++) {
                count++;
                if (j >= 3) {
                    //                    break ok;
                }
            }
        }
        System.out.println(count);
        String str = super.getClass().getName();
        System.out.println(str);
    }
}
