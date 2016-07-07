package com.tangzq.producer.consumer;

import com.tangzq.producer.config.KafkaProperties;
import com.tangzq.producer.model.Product;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.springframework.util.SerializationUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Kafka消息消费封裝类
 */
public class KafkaObjectConsumer extends Thread {
    private final ConsumerConnector consumer;
    private final String topic;
    public KafkaObjectConsumer(String topic)
    {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig());
        this.topic = topic;
    }
    private static ConsumerConfig createConsumerConfig()
    {
        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaProperties.zkConnect);
        props.put("group.id", KafkaProperties.groupId);
        props.put("auto.commit.interval.ms", "1000");
        props.put("zookeeper.session.timeout.ms", "40000");
        props.put("zookeeper.sync.time.ms", "200");
        return new ConsumerConfig(props);
    }
    @Override
    public void run() {
        Map<String, Integer> topicCountMap = new HashMap();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            Product prod= (Product) SerializationUtils.deserialize(it.next().message());;
            System.out.println("receive：" +prod.toString());
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
