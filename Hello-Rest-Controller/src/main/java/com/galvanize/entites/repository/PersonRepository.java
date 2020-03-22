package com.galvanize.entites.repository;

import com.galvanize.entites.Person;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    List<Person> people = new ArrayList<>();

    Long nextId = 1L;

    //CREATE
    public Person save (Person person){
        person.setid(nextId++);
        people.add(person);
        return person;
    }

    //READ
    public List<Person> findAll(){
        return people;
    }
}
