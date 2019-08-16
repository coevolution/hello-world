package com.johnlu.exercise.producerconsumer;

import java.util.*;

/**
 * @author lxp
 * @date 2019/8/8 下午2:48
 * @Version 1.0
 */
public class SynchronizedTest {
    static int size = 10;
//    private static List<Shoe> shoes = Collections.synchronizedList(new ArrayList<>(10));
//    private static Map shoesMap = Collections.synchronizedMap(new HashMap<>(16));
    private static List<Shoe> shoes = new ArrayList<>(10);
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ProduceTask(new Producer("nike")));
        Thread thread2 = new Thread(new ConsumeTask(new Consumer()));
        thread2.start();
//        Thread.sleep(5000);
        thread1.start();
    }

    public static class Producer {
        String name;
        public Producer(String name) {
            name = name;
        }
        public int produce(List<Shoe> shoes) {
            System.out.println("开始生产,现有"+shoes.size()+"双");
            Shoe shoe = new Shoe();
            shoe.setBrandName(name);
            boolean b = shoes.add(shoe);
            System.out.println("生产一次,剩余"+shoes.size());
            return b? 1:0;
        }
    }
    public static class Consumer {
        public int consume(List<Shoe> shoes) {
            System.out.println("开始消费,现有"+shoes.size()+"双");
            shoes.remove(0);
            System.out.println("消费一次,剩余"+shoes.size());
            return 1;
        }
    }

    private static class ProduceTask implements Runnable {
        private Producer producer;
        public ProduceTask(Producer producer) {
            this.producer = producer;
        }
        @Override public void run() {

            while(true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (shoes) {
                if(shoes.size() < size) {
                    producer.produce(shoes);
                } else {
                    try {
                        shoes.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                }
            }
        }
    }

    private static class ConsumeTask implements Runnable {
        private Consumer consumer;
        public ConsumeTask(Consumer consumer) {
            this.consumer = consumer;
        }
        @Override public void run() {

            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (shoes) {
                    if(shoes.size() > 0) {
                        consumer.consume(shoes);
                    } else {
                        shoes.notify();
                    }
                }
            }
        }
    }
}
