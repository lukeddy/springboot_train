package com.tangzq.producer.producer;

import com.tangzq.producer.config.KafkaProperties;
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
        props.put("serializer.class", "com.tangzq.producer.serializer.ProductSerializer");
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", KafkaProperties.kafkaServerURL+":"+KafkaProperties.kafkaServerPort);
        producer = new kafka.javaapi.producer.Producer(new ProducerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true)
        {
            Product prod=new Product(123+messageNo,"Android系列"+messageNo,"Google",new Date());
            System.out.println("Send:" + prod.toString());
            producer.send(new KeyedMessage(topic, prod));
            messageNo++;
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
