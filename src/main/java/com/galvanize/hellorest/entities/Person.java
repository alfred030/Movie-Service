package com.galvanize.hellorest.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Person {
    Long id;
    String name;
    String email;
    LocalDate birthDate;

    pubic Person(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LoacalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge(){
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
