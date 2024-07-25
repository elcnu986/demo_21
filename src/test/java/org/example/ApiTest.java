package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ApiTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisObjTemplate;

    @Test
    void testRedis() {
        Long ret = redisObjTemplate.opsForList().leftPushAll("list", List.of(Map.of(1, 1), Map.of(2, 2), Map.of(3, 3)));
        System.out.println(ret);
    }
}
