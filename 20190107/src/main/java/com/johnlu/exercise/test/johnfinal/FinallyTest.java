package com.johnlu.exercise.test.johnfinal;

/**
 * @author lxp
 * @date 2019/8/21 下午3:54
 * @Version 1.0
 */
public class FinallyTest {
    public static void main(String[] args) {
        try {
        String str = null;
        int i = 0;
        if(i == 0) {
            return;
        }

            System.out.println("try executed");
        }finally {
            System.out.println("finally executed");
        }
    }
}
