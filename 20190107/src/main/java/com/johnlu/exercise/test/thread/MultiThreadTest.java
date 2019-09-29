package com.johnlu.exercise.test.thread;

/**
 * @author lxp
 * @date 2019/9/18 上午10:12
 * @Version 1.0
 */
public class MultiThreadTest {
    int count;
    private void add() {
        for(int i=0;i<100;i++) {
            count++;
            System.out.println(count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] as) throws InterruptedException {
        MultiThreadTest target = new MultiThreadTest();
        Thread t1 = new Thread(new Runnable() {
            @Override public void run() {
                target.add();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override public void run() {
                target.add();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override public void run() {
                target.add();
            }
        });
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(30000);
    }
}
