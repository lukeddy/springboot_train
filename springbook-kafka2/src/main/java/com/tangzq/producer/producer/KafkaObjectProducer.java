package com.tangzq.producer.producer;

import com.tangzq.producer.model.Product;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Date;
import java.util.Properties;

/**
 * Author tangzq.
 */
public class KafkaObjectProducer extends Thread {
    private final kafka.javaapi.producer.Producer<Integer, Product> producer;
    private final String topic;
    private final Properties props = new Properties();

    public KafkaObjectProducer(String topic)
    {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "127.0.0.1:9092");
        producer = new kafka.javaapi.producer.Producer<Integer, Product>(new ProducerConfig(props));
        this.topic = topic;
    }
    @Override
    public void run() {
        int messageNo = 1;
        while (true)
        {
            Product prod=new Product();
            prod.setId(123+messageNo);
            prod.setName("msgName");
            prod.setCompany("hello");
            prod.setDate(new Date());
            System.out.println("Send:" + prod.getId());
            producer.send(new KeyedMessage<Integer, Product>(topic, prod));
            messageNo++;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
