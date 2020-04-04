package com.galvanize.jokes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokeService {


    private static JokeRepository jokeRepository;
    JokeRepository jokeRepository;

    public JokeService(JokeRepository repository) {
        this.jokeRepository = repository;
    }

    Joke createJoke(Joke joke) {
        return jokeRepository.save(joke);
    }

    List<Joke> getAllJoke() {

        return jokeRepository.findAll();
    }

    Joke getJokeById(Long id) {
        Optional<Joke> optionalJoke = jokeRepository.findById(id);
        return optionalJoke.orElse(null);
    }

    static boolean deleteJokeById(Long id) {
        try {
            jokeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
