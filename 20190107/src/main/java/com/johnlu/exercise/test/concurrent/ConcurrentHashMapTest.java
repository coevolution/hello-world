package com.johnlu.exercise.test.concurrent;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lxp
 * @date 2019/7/29 下午4:35
 * @Version 1.0
 */
public class ConcurrentHashMapTest {
    private static final CountDownLatch countDownLatch = new CountDownLatch(2);
    private static  final CountDownLatch start = new CountDownLatch(1);
    private static JohnMap cchm = new JohnMap();

    private static class RunAdd implements Runnable{
        private JohnMap in;
        public RunAdd(JohnMap o) {
            this.in = o;
        }
        @Override public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName+" start to wait!!");
                start.await();
                System.out.println(threadName+" awake!!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             for(int i=0;i<10000;i++) {
                 in.put(threadName+i,new HashCodeBuilder().append(i));
             }
             countDownLatch.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException {

//        for(int i =0;i<1000;i++) {
//            System.out.println(cchm.size());
//            cchm.put("test"+i,new HashCodeBuilder().append(i));
//        }

        Thread thread1 = new Thread(new RunAdd(cchm));
        Thread thread2 = new Thread(new RunAdd(cchm));
        thread1.start();
        thread2.start();
        long startTime = System.currentTimeMillis();
//        start.countDown();
        if(countDownLatch.await(10000, TimeUnit.MILLISECONDS)) {
            System.out.println("countDownLatch count to zero!");
        } else {
            System.out.println("countDownLatch timeout elapsed!");
        }
//        Thread.sleep(3000);
        System.out.println("耗时:"+(System.currentTimeMillis() - startTime)+",size="+cchm.size());
    }
}
