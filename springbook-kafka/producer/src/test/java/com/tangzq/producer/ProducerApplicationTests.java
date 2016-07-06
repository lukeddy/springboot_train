package com.tangzq.producer;

import com.tangzq.producer.service.KafkaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProducerApplication.class)
@WebAppConfiguration
public class ProducerApplicationTests {

	@Autowired
	KafkaService kafkaService;

	@Test
	public void contextLoads() {
		kafkaService.sendMessage("topic-01","abc1321313123");
	}
}
