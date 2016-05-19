package com.yocool.redis.queue;


public interface MessagePublisher {

    void publish(final String message);
}
