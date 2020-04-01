package com.galvanize.controllers;

import com.galvanize.jokes.entities.Joke;
import com.galvanize.repositories.JokeRepository;
import jdk.jfr.Category;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class JokeControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    JokeController controller;

    @MockBean
    JokeRepository jokeRepository;

    ObjectMapper mapper = new ObjectMapper();

    List<Joke> testJokes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        assertNotNull(mvc);
        asserNotNull(controller);

        //Generate Test Data
        for (int i = 1; i <=10; i++) {
            if(i %2 = 0){
                testJokes.add(new.Joke((long) (i * 1000), Category.DADJOKES, "This is a dad joke number "+i));
                else
                    testJokes.add(new Joke((long) (i * 2000), Category.TECHNOLOGY, "This is a technology joke number"+i))
            }
        }
    }

    private void asserNotNull(JokeController controller) {
    }
}
