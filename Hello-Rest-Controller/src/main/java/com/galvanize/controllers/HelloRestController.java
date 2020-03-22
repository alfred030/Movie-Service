package com.galvanize.controllers;

import com.galvanize.entites.Person;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class HelloRestController {
    public Person createPerson(@RequestParam String name, @RequestParam String email, @RequestParam LocalDate birthdate, @RequestParam Long id){
       return new Person(name, email, birthdate
               , id);
    }

    /*** CREATE ***/
    @GetMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return person;
    }

    /*** READ ***/
    @GetMapping("/api")
    public List<Person> getPeople(){
        return personRepository.findAll();
    }
}
