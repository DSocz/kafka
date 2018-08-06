package com.example.demo;

import com.example.demo.dto.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
//		Animal animalDog = new Animal("pies", "ssak");
//		Sender sender = new Sender();
//		sender.send("test.t", animalDog);
	}

}
