package com.johnlu.exercise.hongbao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxp
 * @date 2019/8/2 下午9:51
 * @Version 1.0
 */
public class AppMain {
    private static final int totalAmount = 10000;
    private static final int count = 20;
    private static HongBao hb = new HongBao(count, totalAmount);

    public static void main(String[] args) throws InterruptedException {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            users.add(new User("user" + i, 0));
        }
        for (int i = 0; i < 30; i++) {
            Thread t1 = new Thread(new RunTask(users.get(i)));
            t1.start();
            //            t1.join();
        }

        Thread.sleep(1000);
        synchronized (hb) {
            System.out.println("开始抢红包!");
            hb.notifyAll();
        }

    }

    private static class RunTask implements Runnable {
        private User user;

        public RunTask(User user) {
            this.user = user;
        }

        @Override public void run() {
            synchronized (hb) {
                String threadName = Thread.currentThread().getName();
                try {
                    System.out.println(threadName + "-" + user.getName() + "等待抢红包!");
                    hb.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (user.getHongBao(hb)) {
                    System.out.println(threadName + "-抢到第" + hb.getCurrentCount() + "个红包");
                } else {
                    System.out.println(threadName + "-抢红包失败" + hb);
                }
            }
        }
    }
}
