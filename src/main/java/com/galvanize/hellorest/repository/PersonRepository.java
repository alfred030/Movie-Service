package com.galvanize.hellorest.repository;

import com.galvanize.hellorest.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    List<Person> people = new ArrayList<>();

    Long nextId = 1L;

    //CREATE
    publc Person save(Person person){
        person.setID(nextId++);
        people.add(person);
        return person;
    }
}
