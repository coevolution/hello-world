package com.johnlu.exercise.test.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lxp
 * @date 2019/8/22 上午9:31
 * @Version 1.0
 */
public class SynchronizeQueueTest {
    static SynchronousQueue synchronousQueue = new SynchronousQueue(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override public void run() {
                Object o = null;
                try {
                    o = synchronousQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(o);
            }
        }).start();
        Thread.sleep(5000);
        String str = "john";
        System.out.println(synchronousQueue.offer(str));

    }
}
