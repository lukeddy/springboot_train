package com.yocool;

import com.yocool.redis.config.RedisConfig;
import com.yocool.redis.queue.RedisMessagePublisher;
import com.yocool.redis.queue.RedisMessageSubscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class RedisMessageListenerTest {

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    @Test
    public void testOnMessage() throws Exception {
        String message = "Message " + UUID.randomUUID();
        redisMessagePublisher.publish(message);
        Thread.sleep(100);
        assertTrue(RedisMessageSubscriber.messageList.get(0).contains(message));
    }
}