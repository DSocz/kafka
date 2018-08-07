package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.io.Serializable;

@JsonTypeInfo(use = Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = Dog.class),
})
public abstract class Animal implements Serializable {

    private String species;
    private String gromada;
    private BirthCertificate birthCertificate;

    public Animal() {
    }

    public Animal(String gatunek, String gromada, BirthCertificate birthCertificate) {
        this.species = gatunek;
        this.gromada = gromada;
        this.birthCertificate = birthCertificate;
    }

    public BirthCertificate getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(BirthCertificate birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public String getSpecies() {
        return species;
    }

    public String getGromada() {
        return gromada;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGromada(String gromada) {
        this.gromada = gromada;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", gromada='" + gromada + '\'' +
                ", birthCertificate=" + birthCertificate +
                '}';
    }
}
