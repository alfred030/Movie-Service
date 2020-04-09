package com.galvanize.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entity.Movie;
import com.galvanize.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MovieControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    MovieService movieService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void postMovie() throws Exception {
       Movie expected = new Movie();
        String json = objectMapper.writeValueAsString(expected);
        expected.setMovieId(1L);
        when(movieService.postMovie(any(Movie.class))).thenReturn(expected);
        mvc.perform(post("/api/movies").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.reviewId").value(expected.getMovieId()));
    }


    @Test
    public void getAllMovies() throws Exception {
        Movie expected = new Movie();
        expected.setMovieId(1L);
        ArrayList<Movie> movie = new ArrayList<>();
        movie.add(expected);
        when(movieService.getAllMovies()).thenReturn(movie);
        mvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].movieId").value(expected.getMovieId()));
    }

    @Test
    public void getOneMovieByimdbId() throws Exception {
        Movie expected = new Movie();
        expected.setMovieId(1L);
        when(movieService.findMovieByImdbId("tt0241527")).thenReturn(expected);
         mvc.perform(get("/api/reviews/imdbId/tt0241527"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.imdbId").value(expected.getImdbId()))
                .andExpect((ResultMatcher) jsonPath("$.movieId").value(expected.getMovieId()));
    }

    @Test

    public void updateMovie() throws Exception {
        Movie expected = new Movie();
        expected.setMovieId(1L);
        String json = objectMapper.writeValueAsString(expected);
        when(movieService.updateMovieWithStarRating(anyLong(), any(Movie.class))).thenReturn(expected);
        mvc.perform(put("/api/reviews/rating/1").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.reviewId").value(expected.getMovieId()));
    }

    @Test
    public void deleteMovieById() throws Exception {
        when(movieService.deleteById(anyLong())).thenReturn(true);
        mvc.perform(delete("/api/reviews/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$").value(true));
    }
}