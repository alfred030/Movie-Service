package com.galvanize.hellorest.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class PersonController {

    @GetMapping("/person")
    public Person createPerson(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam LocalDate birthdate){

          LocalDate bd = LocalDate.parse(birthdate);
          return new Person(name, email, birthdate);
    }

    /*** CREATE ***/
    @PostMapping("/PERSON")
    public Person createPerson(@RequestBody Person peron){
        return personRepository.save(person);
    }

    /*** READ ***/
    @GetMapping("/person")
    public List<Person> getPople(){
        return personRepository.findAll();
    }
    }

