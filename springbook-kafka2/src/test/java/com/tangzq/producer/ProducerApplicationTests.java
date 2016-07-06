package com.tangzq.producer;

import com.tangzq.producer.config.KafkaProperties;
import com.tangzq.producer.consumer.KafkaConsumer;
import com.tangzq.producer.consumer.KafkaConsumer2;
import com.tangzq.producer.producer.KafkaStringProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProducerApplication.class)
@WebAppConfiguration
public class ProducerApplicationTests {

	@Test
	public void testProducerAndConsumer() throws InterruptedException {
		KafkaStringProducer producerThread = new KafkaStringProducer(KafkaProperties.topic);
		producerThread.start();
		KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
		consumerThread.start();
		Thread.sleep(20000);
	}

	@Test
	public void testProducerAndConsumer2() throws InterruptedException {
		KafkaStringProducer producerThread = new KafkaStringProducer(KafkaProperties.topic);
		producerThread.start();
		KafkaConsumer2 consumerThread = new KafkaConsumer2(KafkaProperties.topic);
		consumerThread.start();
		Thread.sleep(20000);
	}
}
