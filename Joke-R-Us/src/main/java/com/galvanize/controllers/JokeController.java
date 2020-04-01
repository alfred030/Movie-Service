package com.galvanize.controllers;

import com.galvanize.jokes.entities.Category;
import com.galvanize.jokes.entities.Joke;
import com.galvanize.services.JokeService;

import java.util.List;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    JokeService jokeService;

    public JokeController(JokeService jkeService) { this.jokeService = jokeService;}

    @PostMapping
    public Joke createJoke(@RequestBody Joke joke) { return jokeService.addJoke(joke); }

    @GetMapping
    public List<Joke> getAllJokes() {return jokeService.getAllJokes();}

    @GetMapping("/search")
    public List<Joke> getJokesContaining(@RequestParm String searchString){
        return jokeService.findJokeContaining(searchString);
    }

    void GetMapping("category/{category}")
        public java.util.List<Joke> getJokesByCategory(@Patchvariable Category category){
        return jokeService.findJokesByCategory(category);
        }
}
