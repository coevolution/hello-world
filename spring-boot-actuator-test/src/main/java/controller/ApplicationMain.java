package controller;

import hello.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * @author lxp
 * @date 2019/6/26 下午5:13
 * @Version 1.0
 */
@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
        RedisHelper redisHelper = new RedisHelper();
        List<String> keys = redisHelper.keys("TP-PAYMENT-*");
    }
}
