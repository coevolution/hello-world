package cn.john.lu;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.IntegerCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lxp
 * @date 2019/7/25 下午4:55
 * @Version 1.0
 */
@Slf4j
public class AppMain {
    private static RedissonClient redissonClient;
    static {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer();
        serverConfig.setAddress("redis://192.168.5.243:6379");
        serverConfig.setPassword("Dashu0701");
        redissonClient = Redisson.create(config);
    }
    public static void main(String[] args) throws IOException, InterruptedException {


        System.out.println(redissonClient.getConfig().toJSON());
//        RKeys l = redissonClient.getKeys();
//        l.getKeys().forEach(System.out::println);
//        RLock lock1 = redissonClient.getLock("myhash");
//        boolean r = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
        RBucket<Object> b1 = redissonClient.getBucket("myhash");
        b1.set("1234");
//        redissonClient.getBucket("myhash");
//        RReadWriteLock rwLock = redissonClient.getReadWriteLock("john-test");

        String redisKey = "channel"+"-"+1;
        RMapCache<Object, Object> mapCache1 =
            redissonClient.getMapCache("nameSpace", IntegerCodec.INSTANCE);
        mapCache1.putIfAbsent(redisKey,0,1,TimeUnit.MINUTES);
        int incr = (int) mapCache1.addAndGet(redisKey,2);
        log.info("获取redis计数器：{}", redisKey);
        Thread.sleep(1000);
        redissonClient.shutdown();
    }

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    @Test
    public void testReadLockReadable() {
        RLock readLock = redissonClient.getReadWriteLock("myhash").readLock();
        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                String threadName = Thread.currentThread().getName();
                try {
                    log.info(threadName+"开始执行");
                    Thread.sleep(2000);
                    RLock readLock = redissonClient.getReadWriteLock("myhash").readLock();
                    if(readLock.tryLock(100,100000,TimeUnit.MILLISECONDS)) {
                        log.info(threadName+"读锁获取成功", readLock.getName());
                        Thread.sleep(50000);
                        readLock.unlock();
                        log.info(threadName+"读锁释放成功", readLock.getName());
                        countDownLatch.countDown();
                    } else {
                        log.info(threadName+"读锁获取失败");
                        Thread.sleep(5000);
                        countDownLatch.countDown();
                    }

                } catch (InterruptedException e) {
                    log.info(threadName+"异常");
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        if(readLock.tryLock()) {
            String threadName = Thread.currentThread().getName();
            try {
                log.info(threadName+"读锁获取成功,等待count down.{}", readLock.getName());
                countDownLatch.await();
                log.info(threadName+"读锁等待count down已结束.{}", readLock.getName());
                readLock.unlock();
                log.info(threadName+"读锁释放成功.{}", readLock.getName());
            } catch (InterruptedException e) {
                log.info(threadName+"异常", readLock.getName());
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testReadLockNotWritable() {
        RLock readLock = redissonClient.getReadWriteLock("myhash").readLock();
        Thread thread = new Thread(new Runnable() {
            @Override public void run() {
                String threadName = Thread.currentThread().getName();
                try {
                    log.info(threadName+"开始执行");
                    Thread.sleep(2000);
                    RLock writeLock = redissonClient.getReadWriteLock("myhash").writeLock();
                    if(writeLock.tryLock(100,100000,TimeUnit.MILLISECONDS)) {
                        log.info(threadName+"写锁获取成功", writeLock.getName());
                        Thread.sleep(50000);
                        writeLock.unlock();
                        log.info(threadName+"写锁释放成功", writeLock.getName());
                        countDownLatch.countDown();
                    } else {
                        log.info(threadName+"写锁获取失败");
                        Thread.sleep(5000);
                        countDownLatch.countDown();
                    }

                } catch (InterruptedException e) {
                    log.info(threadName+"异常");
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        if(readLock.tryLock()) {
            String threadName = Thread.currentThread().getName();
            try {
                log.info(threadName+"读锁获取成功,等待count down.{}", readLock.getName());
                countDownLatch.await();
                log.info(threadName+"读锁等待count down已结束.{}", readLock.getName());
                readLock.unlock();
                log.info(threadName+"读锁释放成功.{}", readLock.getName());
            } catch (InterruptedException e) {
                log.info(threadName+"异常", readLock.getName());
                e.printStackTrace();
            }
        }
    }
}
