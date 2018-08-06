package com.example.demo;

import com.example.demo.dto.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    @Autowired
    MessageStorage messageStorage;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "test_animal", groupId = "helloworld")
    public void receive(Animal animal) {
        LOGGER.info("received payload='{}'", animal);
        latch.countDown();
        messageStorage.put(animal);
    }
}
