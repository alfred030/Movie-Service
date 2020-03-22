package com.galvanize.entites;

import java.time.LocalDate;

public class Person {
    String name;
    String email;
    LocalDate birthDate;
    Long id;

    public Person(String name, String email, LocalDate birthDate, Long id) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.id = id;
    }

    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(String email) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId(Long id) {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
}
