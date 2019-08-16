package com.johnlu.exercise.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lxp
 * @date 2019/8/8 下午1:53
 * @Version 1.0
 */
public class ReentrantLockTest {
    boolean flag = false;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        if(lock.tryLock()) {

        }
    }

    @Test
    public void test1() {
        Thread thread = new Thread(new Runnable() {
//            boolean t;
            @Override public void run() {
            try {
                Thread.sleep(5000);
                flag = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
        thread.start();
        while(!flag) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("loop continue");
        }
    }
}
