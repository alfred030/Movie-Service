package com.galvanize.jokes;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/joke")
public class JokeController<joke> {
    JokeService jokeService;

    public JokeController(JokeService service) {
        this.jokeService = service;
    }

    @PostMapping
    ResponseEntity<String> createJoke(@RequestBody Joke joke) {
        if (joke.getCategory() == null) {
            return ResponseEntity.badRequest().body("Category cannot be null.");
        }
        return null;
    }

    @GetMapping
    ResponseEntity<List<Joke>> getJokes() {
        return ResponseEntity.ok(jokeService.getAllJoke());
    }

    @GetMapping("/{id}")
    ResponseEntity<Joke> getJokeById(@PathVariable Long id) {
        return ResponseEntity.ok(jokeService.getJokeById(id));
    }

    @DeleteMapping("{id}")
   ResponseEntity<Object> deleteJokeById(@PathVariable Long id) {
        boolean successfulDeletion = JokeService.deleteJokeById(id);
        if(successfulDeletion) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.badRequest().body("Joke with id" + id + " was not found");
        }
    }
}
