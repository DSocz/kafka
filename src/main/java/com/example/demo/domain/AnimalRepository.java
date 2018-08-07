package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AnimalRepository{

    @Autowired
    EntityManager em;

    public List<Object> getSpecies(Integer speciesId){
        Query q = em.createNativeQuery(" SELECT species.name FROM animals.species species WHERE species.id =1 ") ;

      return q.getResultList();

    }
}
