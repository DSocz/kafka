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

    private String gatunek;
    private String gromada;
    private BirthCertificate birthCertificate;

    public Animal() {
    }

    public Animal(String gatunek, String gromada, BirthCertificate birthCertificate) {
        this.gatunek = gatunek;
        this.gromada = gromada;
        this.birthCertificate = birthCertificate;
    }

    public BirthCertificate getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(BirthCertificate birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getGromada() {
        return gromada;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public void setGromada(String gromada) {
        this.gromada = gromada;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "gatunek='" + gatunek + '\'' +
                ", gromada='" + gromada + '\'' +
                ", birthCertificate=" + birthCertificate +
                '}';
    }
}
