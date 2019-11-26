package com.johnlu.exercise.lock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.johnlu.exercise.StringThread;
import com.johnlu.exercise.StringThreadCallable;

import java.util.concurrent.*;

public class StringThreadMain {
    private static ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(4, 8, 10000, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>(), new ThreadFactoryBuilder().build());

    public static void main(String[] args) {
        System.out.println("main start");
        String a = "avd";
        String temp = "vd";
        String b = "a" + temp;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == b.intern());
        System.out.println("main end");
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.execute(new StringThread(String.valueOf(1)));
        }
        threadPoolExecutor.submit(new Thread());
    }
}
