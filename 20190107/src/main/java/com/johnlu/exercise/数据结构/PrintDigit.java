package com.johnlu.exercise.数据结构;

/**
 * @author lxp
 * @date 2019/12/3 下午7:03
 * @Version 1.0
 */
public class PrintDigit {
    public static void main(String[] args) {
        printDigit(3430892);
    }

    public static void printDigit(int n) {
//        if(n >= 10) {
//            printDigit(n/10);
//        }
//        System.out.print(n % 10);
        if(n<10) {
            System.out.print(n);
        } else {
            printDigit(n/10);
            System.out.print(n%10);
        }
    }
}
