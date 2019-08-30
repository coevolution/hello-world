package com.johnlu.exercise;

import java.util.concurrent.Callable;

/**
 * @author lxp
 * @date 2019/8/26 下午2:45
 * @Version 1.0
 */
public class StringThreadCallable implements Callable<String> {
    private static String LOCK_PREFIX = "XXX---";
    private String ip;
    public StringThreadCallable(String ip) {
        this.ip = ip;
    }

    @Override public String call() {
        String lock = buildLock();
        synchronized (lock) {
            System.out.println("["+Thread.currentThread().getName()+"]"+"开始运行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("["+Thread.currentThread().getName()+"]"+"结束运行");
        }
        return "Success";
    }
    private String buildLock() {
        StringBuilder sb = new StringBuilder();
        sb.append(LOCK_PREFIX);
        sb.append(ip);

        String lock = sb.toString();
        System.out.println("[" + Thread.currentThread().getName()+"]"+"构建了锁:"+lock);
        return lock;
    }
}
