package com.galvanize.controller;


import com.galvanize.entity.Movie;
import com.galvanize.repository.MovieRepository;
import com.galvanize.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieRepository createMovie(@RequestBody Movie input){
        return (MovieRepository) movieService.postMovie(input);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/imdbId/{imdbId}")
    public Movie getOneMovieReviewByimdbId(@PathVariable String imdbId) {
        return movieService.findMovieByImdbId(imdbId);
    }

    @PutMapping("/rating/{reviewId}")
    public Movie updateMovieWithStarRating(@PathVariable long movieId, @RequestBody Movie movie) {
        return movieService.updateMovieWithStarRating(movieId, movie);

    }

    @DeleteMapping("/{id}")
    public boolean updateMovie(@PathVariable long id){
        return movieService.deleteById(id);
    }
}



