package com.johnlu.exercise.lock;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author dashu
 */
public class TryStampedLock {
    private static final StampedLock stampedLock = new StampedLock();
    /**
     * StampedLock读写锁,读可并发
     */
    @Test
    public void test1() {
        long stamp1 = stampedLock.tryReadLock();
        System.out.println("主线程获取读锁stamp="+stamp1);
        Thread thread1 = new Thread(new Runnable() {
            @Override public void run() {
                long stamp2 = 0l;
                while(stamp2 ==0l) {
                    System.out.println("每隔10毫秒尝试获取读锁");
                    try {
                        stamp2 = stampedLock.tryReadLock(10,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(stamp2 != 0L) {
                    stampedLock.unlockRead(stamp2);
                    System.out.println("成功获取读锁stamp=" + stamp2);
                } else {
                    System.out.println("未能释放读锁stamp=" + stamp2);
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stampedLock.unlockRead(stamp1);
        System.out.println("主线程释放读锁stamp="+stamp1);
    }
    /**
     * StampedLock读写锁,读写不可并发
     */
    @Test
    public void test2() {
        long stamp1 = stampedLock.tryReadLock();
        System.out.println("主线程获取读锁stamp="+stamp1);
        Thread thread1 = new Thread(new Runnable() {
            @Override public void run() {
                long stamp2 = 0L;
                try {
                    stamp2 = stampedLock.tryWriteLock(900,TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(stamp2 != 0L) {
                    System.out.println("成功获取写锁stamp=" + stamp2);
                    stampedLock.unlockWrite(stamp2);
                    System.out.println("成功释放写锁stamp=" + stamp2);
                } else {
                    System.out.println("未获取写锁stamp=" + stamp2);
                }
            }
        });
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程释放读锁stamp="+stamp1);
        stampedLock.unlockRead(stamp1);
    }
    /**
     * StampedLock读写锁,乐观读锁被写锁抢占
     */
    @Test
    public void test3() throws InterruptedException {
        long stamp1 = stampedLock.tryOptimisticRead();
        System.out.println("主线程获取乐观读锁stamp="+stamp1);
        Thread thread1 = new Thread(new Runnable() {
            @Override public void run() {
                long stamp2 = 0L;
                while(stamp2 ==0L) {
                    System.out.println("每隔10毫秒尝试获取写锁");
                    try {
                        stamp2 = stampedLock.tryWriteLock(10,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("成功获取写锁stamp="+stamp2);
                stampedLock.unlockWrite(stamp2);
                System.out.println("成功释放写锁stamp="+stamp2);
            }
        });
        thread1.start();
        Thread.sleep(1000);
        if(stampedLock.validate(stamp1)) {
            System.out.println("主线程释放乐观读锁stamp="+stamp1);
            stampedLock.unlockRead(stamp1);
        } else {
            System.out.println("主线程无法释放乐观读锁stamp="+stamp1);
        }
    }
    @Test
    public void test4() {
        StampedLock stampedLock1 = new StampedLock();
        final StampedLock stampedLock2 = new StampedLock();
        Assert.assertFalse(stampedLock1.equals(stampedLock2));
        StampedLock stampedLock3 = stampedLock2;
        int before = stampedLock2.getReadLockCount();
        stampedLock2.readLock();
        int after = stampedLock2.getReadLockCount();
        Assert.assertTrue(before != after);


    }
}
