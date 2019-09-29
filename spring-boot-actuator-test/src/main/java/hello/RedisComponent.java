package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Configuration
@Component
public class RedisComponent {
    @Autowired
    private RedisTemplate redisTemplate;

    public RedisComponent() {
    }

    @Bean
    @Primary JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        this.redisTemplate.setConnectionFactory(this.jedisConnectionFactory());
        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
        return this.redisTemplate;
    }

    public void remove(String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            this.remove(key);
        }

    }

    public void removePattern(String pattern) {
        Set<Serializable> keys = this.redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            this.redisTemplate.delete(keys);
        }

    }

    public void remove(String key) {
        if (this.exists(key)) {
            this.redisTemplate.delete(key);
        }

    }

    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key);
    }

    public Object get(String key) {
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        Object result = operations.get(key);
        return result;
    }

    public boolean set(String key, Object value) {
        boolean result = false;

        try {
            ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }

    public boolean set(String key, Object value, Long expireTime) {
        boolean result = false;

        try {
            ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return result;
    }

    public boolean checkKey() {
        return false;
    }

    public boolean setBit(String key, long offset, boolean value, Long expireTime) {
        boolean result = false;

        try {
            ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
            operations.setBit(key, offset, value);
            this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return result;
    }

    public boolean getBit(String key, long offset) {
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        return operations.getBit(key, offset);
    }

    public Long bitcount(final String key) {
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        this.redisTemplate.boundValueOps(key);
        Object count = this.redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.bitCount(key.getBytes());
            }
        });
        return StringUtils.isEmpty(count) ? 0L : Long.valueOf(count + "");
    }

    public boolean convertAndSend(String key, String value) {
        boolean result = false;

        try {
            this.redisTemplate.convertAndSend(key, value);
            result = true;
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }
}
