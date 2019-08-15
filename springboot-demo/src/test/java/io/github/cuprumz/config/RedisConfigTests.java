package io.github.cuprumz.config;

import io.github.cuprumz.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author cuprumz
 * @date 2019/08/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test1() throws Exception {
        User user = new User("aa1", "aa123456", "aa@126.com", "aa", "123");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.aa", user);
        operations.set("com.aa.1", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);

        boolean exists = redisTemplate.hasKey("com.aa.1");
        System.out.println("------c-u-p-r-u-m------  exists = " + exists);
    }
}
