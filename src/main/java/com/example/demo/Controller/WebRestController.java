package com.example.demo.Controller;

import com.example.demo.MessageStorage;
import com.example.demo.Receiver;
import com.example.demo.Sender;
import com.example.demo.dto.Animal;
import com.example.demo.dto.BirthCertificate;
import com.example.demo.dto.Dog;
import org.apache.kafka.common.network.Receive;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

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

//    @GetMapping(value="/producer/{gatunek}")
//    public String producer(@PathVariable String gatunek){
//        Animal animal = new Animal(gatunek, "ssak");
//        publisher.send("test_animal", animal);
//
//        return "Done";
//    }

    @GetMapping(value="/consumer")
    public String getAllRecievedMessage(){
        String messages = messageStorage.toString();
        messageStorage.clear();
        return messages;
    }

    @PostMapping(value="/postAnimal")
    public ResponseEntity<Animal> postAnimal(@RequestBody Animal animal){

        Animal animalReceived = animal;
        animalReceived.setGatunek("Wolf");
        animalReceived.setGromada("mammals");
        return  new ResponseEntity<Animal>(animalReceived, HttpStatus.OK);
    }

    @GetMapping(value = "/returnJsonDog")
    public ResponseEntity<Dog> returnDog() {
        BirthCertificate birthCertificate = new BirthCertificate(LocalDate.of(2015, 1,23),"Warszawa" );
        Dog dog = new Dog("test1", "test2", "RED", "test4", birthCertificate);

        return new ResponseEntity<Dog>(dog, HttpStatus.OK);
    }
}
