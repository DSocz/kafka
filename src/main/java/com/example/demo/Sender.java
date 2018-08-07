package com.example.demo;

import com.example.demo.dto.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
public class Sender {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, Animal> kafkaTemplate;

    public void send(String topic, Animal animal) {
        LOGGER.info("sending payload='{}' to topic='{}'", animal.toString(), topic);
        ListenableFuture<SendResult<String, Animal>> future = kafkaTemplate.send(topic, animal);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Animal>>() {

            @Override
            public void onSuccess(SendResult<String, Animal> result) {
                LOGGER.info("SUCCESS!!!");
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("FAILUREE!!!");

            }

        });
    }
}
