package com.galvanize.service;

import com.galvanize.entity.Movie;
import com.galvanize.repository.MovieRepository;

import java.util.List;

public class MovieService {

    MovieRepository movieRepository;
    private long movieId;
    private Movie rating;
    private String imdbId;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie postMovie(Movie movie) {
       return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovieByImdbId(String imdbId) {
        this.imdbId = imdbId;
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public Movie updateMovieWithStarRating(long movieId, Movie rating) {
        Movie newMovie = updateMovieWithStarRating(movieId, rating);
        newMovie.update(newMovie);
        return postMovie(newMovie);
    }

    public boolean deleteById(long movieId) {
        if (deleteById(movieId)) return true;
        else return false;
    }
}








