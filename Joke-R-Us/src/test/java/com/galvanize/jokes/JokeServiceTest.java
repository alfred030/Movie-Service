package com.galvanize.jokes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class JokeServiceTest {

    @Autowired
    JokeRepository jokeRepository;

    JokeService jokeService;

    @BeforeEach
    void setup() {
        jokeService = new JokeService(jokeRepository);
    }

    @Test
    void createJoke_returnsJoke() {
        //Setup
        Joke expectedJoke = new Joke(JokeCategory.DADJOKES, "Your dad so small, everybody thinks he is small.");

        //Exercise
        Joke savedJoke = jokeService.createJoke(expectedJoke);

        //Assert
        assertNull(savedJoke.getId());
        assertEquals(expectedJoke.getCategory(), savedJoke.getCategory());
        assertEquals(expectedJoke.getDescription(), savedJoke.getDescription());

        //Teardown
        jokeRepository.deleteAll();
    }

    @Test
    void getAllJoke_returnsJokes() {
        //Setup
        Joke expectedJoke = new Joke(JokeCategory.KNOCKKNOCK, "A bad joke");
        jokeRepository.save(expectedJoke);

        //Exercise
        List<Joke> actual = jokeService.getAllJoke();

        //Assert
        assertEquals(1, actual.size());
        assertEquals(expectedJoke.getCategory(), actual.get(0).getCategory());
        assertEquals(expectedJoke.getDescription(), actual.get(0).getDescription());
    }

    @Test
    void getJokeById_whenJokeExists_returnJoke() {

        //Setup
        Joke expectedJoke = new Joke(JokeCategory.KNOCKKNOCK, "A bad Joke");
        jokeRepository.save(expectedJoke);

        //Exercise
        Joke actual = jokeService.getJokeById(expectedJoke.getId());

        //Assert
        assertEquals(expectedJoke.getCategory(), actual.getCategory());
        assertEquals(expectedJoke.getDescription(), actual.getDescription());
    }

    @Test
    void deleteById_whenJokeExists_returnsTrue() {

        //Setup
        Joke joke = jokeService.createJoke(new Joke(JokeCategory.KNOCKKNOCK, "A bad joke"));

        //Exercise
        boolean actual = jokeService.deleteJokeById(joke.getId());

        //Assert
        assertTrue(actual);
    }
}