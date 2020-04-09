package com.galvanize.service;


import com.galvanize.entity.Movie;
import com.galvanize.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MovieServiceTest {

    @MockBean
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @Test

    public void postMovie() {
        Movie movie = new Movie("paul1@.com", "tt0241527", "Terminator", 4, "hello");
        Movie expected = new Movie(1L, "paul1@gmail.com", "tt0241527", "Terminator", 4, "hello");
        when(movieRepository.save(any(Movie.class))).thenReturn(expected);
        assertEquals(expected, movieService.postMovie(movie));
    }

    @Test

    public void getAllMovies() {
        Movie expected = new Movie(1L, "paul1@gmail.com", "tt0241527", "Terminator", 4, "hello");
        ArrayList<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(expected);
        when(movieRepository.findAll()).thenReturn(expectedMovies);
        assertEquals(expectedMovies, movieService.getAllMovies());
    }

    @Test

    public void getMovieByImdbId() {
        Movie expected = new Movie(1L, "paul1@gmail.com", "tt0241527", "Terminator", 4, "hello");
        when(movieRepository.findMovieByImdbId(anyString())).thenReturn(expected);
        assertEquals(expected, movieService.findMovieByImdbId("tt0241527"));
    }

    @Test

    public void updateMovieWithStarRating(){
        MovieService movieService = new MovieService(movieRepository);
        Movie expected;
        expected = movieService.postMovie(new Movie(1L, "paul1@gmail.com", "tt0241527", "Terminator", 4, "hello"));
        when(movieService.findMovieByImdbId(anyString())).thenReturn(expected);
        assertEquals(expected, movieService.findMovieByImdbId("tt0241527"));
    }

    @Test

    public void deleteMovie() {
       when(movieService.deleteById(anyLong())).thenReturn(true);
        assertTrue(movieService.deleteById(1L));
    }
}
