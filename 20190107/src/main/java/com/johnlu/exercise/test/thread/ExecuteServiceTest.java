package com.johnlu.exercise.test.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lxp
 * @date 2019/7/23 上午11:25
 * @Version 1.0
 */
public class ExecuteServiceTest {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        System.out.println("main start");
        long mainStart = System.currentTimeMillis();
        executorService.execute(()->{
            System.out.println("execute start");
            long start =System.currentTimeMillis();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("execute end.execute time="+(System.currentTimeMillis()-start)+executorService.isShutdown());
        });
        System.out.println("main end.execute time="+(System.currentTimeMillis()-mainStart));
    }
    @Test
    public void test1() {
        System.out.println("main start");
        long mainStart = System.currentTimeMillis();
        executorService.execute(()->{
            System.out.println("execute start");
            long start =System.currentTimeMillis();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.shutdown();
            System.out.println("execute end.execute time="+(System.currentTimeMillis()-start)+executorService.isShutdown());
        });
        System.out.println("main end.execute time="+(System.currentTimeMillis()-mainStart));
    }
}
