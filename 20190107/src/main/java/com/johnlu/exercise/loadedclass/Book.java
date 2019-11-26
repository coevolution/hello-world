package com.johnlu.exercise.loadedclass;

/**
 * @author lxp
 * @date 2019/8/7 上午11:42
 * @Version 1.0
 */
public class Book {
    public static void main(String[] args) {
        System.out.println("Hello ShuYi.");
        Book book = new Book();
    }

    Book() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    {
        System.out.println("书的普通代码块");
    }

    int price = 110;

    static {
        System.out.println("书的静态代码块");
    }

    static int amount = 112;
}
