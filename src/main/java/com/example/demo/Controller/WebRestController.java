package com.example.demo.Controller;

import com.example.demo.MessageStorage;
import com.example.demo.Receiver;
import com.example.demo.Sender;
import com.example.demo.dto.Animal;
import org.apache.kafka.common.network.Receive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/jsa/kafka")
public class WebRestController {

    @Autowired
    Sender publisher;

    @Autowired
    MessageStorage messageStorage;

    @GetMapping(value="/test")
    public String test(){
        return "Test complete";
    }


    @GetMapping(value="/producer/{gatunek}")
    public String producer(@PathVariable String gatunek){
        Animal animal = new Animal(gatunek, "ssak");
        publisher.send("test_animal", animal);

        return "Done";
    }

    @GetMapping(value="/consumer")
    public String getAllRecievedMessage(){
        String messages = messageStorage.toString();
        messageStorage.clear();
        return messages;
    }

    @PostMapping(value="/postAnimal")
    public ResponseEntity<Animal> postAnimal(@RequestBody Animal animal){

        Animal animelReceived = animal;
        return  new ResponseEntity<Animal>(animelReceived, HttpStatus.OK);
    }
}
