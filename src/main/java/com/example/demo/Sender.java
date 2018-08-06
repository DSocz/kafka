package com.example.demo;

import com.example.demo.dto.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, Animal> kafkaTemplate;

    public void send(String topic, Animal animal) {
        LOGGER.info("sending payload='{}' to topic='{}'", animal.toString(), topic);
        kafkaTemplate.send(topic, animal);
    }
}
