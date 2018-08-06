package com.example.demo;

import com.example.demo.dto.Animal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageStorage {

    private List<Animal> storage = new ArrayList<Animal>();

    public void put(Animal animal){
        storage.add(animal);
    }

    public Animal get(Integer id){
        return storage.get(id);
    }

    public void clear(){
        storage.clear();
    }


    public String toString(){
        StringBuffer info = new StringBuffer();
        storage.forEach(msg->info.append(msg).append("<br/>"));
        return info.toString();
    }
}
