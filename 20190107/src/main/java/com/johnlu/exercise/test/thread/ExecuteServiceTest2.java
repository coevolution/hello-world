package com.johnlu.exercise.test.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author lxp
 * @date 2019/8/5 上午11:19
 * @Version 1.0
 */
public class ExecuteServiceTest2 {
    private static ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
//    private static ExecutorService executorService =
//        new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2,
//            Runtime.getRuntime().availableProcessors() * 2, 0, TimeUnit.SECONDS,
//            new LinkedBlockingQueue<Runnable>(),
//            new ThreadFactoryBuilder().setNameFormat("Producer-Pool-%d").build());
private static ExecutorService executorService =
    new ThreadPoolExecutor(2,
        4, 0, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>(),
        new ThreadFactoryBuilder().setNameFormat("Producer-Pool-%d").build());

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            executorService.submit(new RunTask());
        }
        String s = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println(map);
        System.out.println("main thread "+ s + " ended");
    }

    private static class RunTask implements Runnable {

        @Override public void run() {
            String s = Thread.currentThread().getName();
            System.out.println(s+" started");
//            synchronized(map) {
//                Integer i;
//                if((i = map.get(s)) != null) {
//                    i++;
//                    map.put(s,i);
//                } else {
//                    map.put(s,1);
//                }
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s+" ended");
        }
    }
}
