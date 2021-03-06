package com.example.demo;

import com.example.demo.dto.Animal;
import com.example.demo.dto.Dog;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class DemoApplicationTests {

	private static final String HELLOWORLD_TOPIC = "test.t";

	@ClassRule
	public static KafkaEmbedded embeddedKafka =
			new KafkaEmbedded(1, true, HELLOWORLD_TOPIC);

	@Autowired
	private Receiver receiver;

	@Autowired
	private Sender sender;

	@Test
	public void testReceive() throws Exception {

		Animal animal = new Dog();
		sender.send(HELLOWORLD_TOPIC, animal);

		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(receiver.getLatch().getCount()).isEqualTo(0);

	}

}
