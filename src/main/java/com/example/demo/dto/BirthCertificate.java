package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Date;

public class BirthCertificate  {

    private LocalDate date;
    private String city;

    public BirthCertificate() {
    }

    public BirthCertificate(LocalDate date, String city) {
        this.date = date;
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "BirthCertificate{" +
                "date=" + date +
                ", city='" + city + '\'' +
                '}';
    }
}
