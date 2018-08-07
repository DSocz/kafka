package com.example.demo.dto;

public class Dog extends Animal {

    private String color;
    private String subspecies;

    public Dog() {
        }

    public Dog(String color, String subspecies) {
        this.color = color;
        this.subspecies = subspecies;
    }

    public Dog(String gatunek, String gromada, String color, String subspecies, BirthCertificate birthCertificate) {
        super(gatunek, gromada, birthCertificate);
        this.color = color;
        this.subspecies = subspecies;
    }

    public String getColor() {
        return color;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                ", subspecies='" + subspecies + '\'' +
                '}';
    }
}
