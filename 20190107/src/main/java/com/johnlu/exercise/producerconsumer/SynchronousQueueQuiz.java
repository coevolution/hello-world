package com.johnlu.exercise.producerconsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author lxp
 * @date 2019/8/13 下午7:39
 * @Version 1.0
 */
public class SynchronousQueueQuiz {
    public static void main(String[] ar) throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.print(queue.offer(1)+" ");
        System.out.print(queue.offer(2)+" ");
        System.out.print(queue.offer(3)+" ");
        System.out.print(queue.take() + " ");
        System.out.println(queue.size());
    }
}
