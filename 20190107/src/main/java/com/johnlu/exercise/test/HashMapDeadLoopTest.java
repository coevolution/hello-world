package com.johnlu.exercise.test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lxp
 * @date 2019/8/24 下午2:09
 * @Version 1.0
 */
public class HashMapDeadLoopTest {
    static HashMap<Integer, Integer> map = new HashMap<>(2);
    static AtomicInteger at = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Test test0 = new Test();
        Test test1 = new Test();
        Test test2 = new Test();
        Test test3 = new Test();
        Test test4 = new Test();
        test0.start();

        test1.start();

        test2.start();

        test3.start();

        test4.start();
        //        test0.join();
        //        test1.join();
        //        test2.join();
        //        test3.join();
        //        test4.join();
        System.out.println(Thread.currentThread().getName() + " end.size=" + map.size());
    }

    static class Test extends Thread {
        @Override public void run() {
            while (at.get() < 10000) {
                map.put(at.get(), at.get());
                at.incrementAndGet();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        }
    }

}
