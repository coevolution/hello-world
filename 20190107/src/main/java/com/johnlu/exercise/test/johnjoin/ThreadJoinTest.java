package com.johnlu.exercise.test.johnjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author lxp
 * @date 2019/7/23 下午7:24
 * @Version 1.0
 */
public class ThreadJoinTest {
    private static List<String> l = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        Thread cu = Thread.currentThread();
        for(int i=0;i<50;i++) {
            Thread thread = new Thread(new DoRun(l));
            thread.setName("myThread"+i);
            thread.start();
            //todo 有问题
            thread.join();
//            try {
//                cu.join();
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//                e.printStackTrace();
//            }
        }

        System.out.println(l.size());
    }

    public static class DoRun implements Runnable{
        List<String> list;
        public DoRun(List<String> list) {
            this.list = list;
        }
        @Override public void run() {
            System.out.println("start "+Thread.currentThread().getName());
            for(int i=0;i<100;i++) {
                list.add(Thread.currentThread().getName()+i);
            }
            System.out.println("end "+Thread.currentThread().getName());
        }
    }
}
