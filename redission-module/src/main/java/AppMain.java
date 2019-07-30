import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.IntegerCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lxp
 * @date 2019/7/25 下午4:55
 * @Version 1.0
 */
public class AppMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppMain.class);


    public static void main(String[] args) throws IOException, InterruptedException {

        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer();
        serverConfig.setAddress("redis://192.168.5.243:6379");
        serverConfig.setPassword("Dashu0701");
        RedissonClient redissonClient = Redisson.create(config);
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
        LOGGER.info("获取redis计数器：{}", redisKey);
        Thread.sleep(1000);
        redissonClient.shutdown();
    }
}
