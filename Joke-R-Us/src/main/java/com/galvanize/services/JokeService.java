package com.galvanize.services;

import com.galvanize.jokes.entities.Category;
import com.galvanize.jokes.entities.Joke;

import java.util.List;

public class JokeService {
    public List<Joke> findJokesByCategory(Category category) {
    }

    public List<Joke> getAllJokes() {
        return jokeRepository.fillAll();
    }
    
    public List<Joke> findJoKesByCategory(Category category) { retun jokeRepository.findAllByCategory(category);}
    
    public Joke getRandomJoke() { return jokeRepository.findRandomJoke(); }
    
    public Joke getRandomJokeByCategory(Category category){
        String catString = category == Category.NA ? "" : category.toString();
        return jokeRepository.findRandomJokeByCategory(catString);
    }
    
    public void deleteById(long Id) {
        JokeService jokeRepository;
        if(jokeRepository.existById(id)) jokeRepository.deleteById(id);
        else{
            throw new RecordNotFoundException("Joke number"+id+" was not found");
        }
    }
    
}
