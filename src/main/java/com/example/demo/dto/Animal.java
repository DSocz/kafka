package com.example.demo.dto;

import java.io.Serializable;

public class Animal implements Serializable {

    private String gatunek;
    private String gromada;

    public Animal() {
    }

    public Animal(String gatunek, String gromada) {
        this.gatunek = gatunek;
        this.gromada = gromada;
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
                '}';
    }
}
