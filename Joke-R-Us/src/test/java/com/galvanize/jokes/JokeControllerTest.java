package com.galvanize.jokes;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.awt.*;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JokeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    JokeService jokeService;

    @Test
    void createJoke_returnsJOKE() throws Exception {
        // Setup
        Joke expectedJoke = new Joke(1L, JokeCategory.KNOCKKNOCK, "Your is fine");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(expectedJoke);

        // Exercise
        mockMvc.perform(post("/api/jokes").content(requestBody).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(notNULLValue()))
                .andExpect(jsonPath("$.description").value(expectedJoke.getDescription()))
                .andExpect(jsonPatch("$.category").value(expectedJoke.getCategory().name()));
    }



    private SuppressWarnings jsonPatch(String s) {
    }

    private SuppressWarnings jsonPath(String s) {
    }

    @Test
    void createJoke_whenNoDescriptionExists_returns400() throws Exception {
        // Setup
        Joke noDescriptionJoke = new Joke();
        noDescriptionJoke.setCategory(JokeCategory.KIDJOKES);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(noDescriptionJoke);

        // Exercise
        mockMvc.perform(post("/api/joke").content(requestBody).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect((ResultMatcher) content().string("Category cannot be null"));
    }

    @Test
    void createJoke_whenNoCategoryExists_returns400() throws Exception {
        // Setup
        Joke noCategoryJoke = new Joke();
        noCategoryJoke.setDescription("Some really funny joke");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(noCategoryJoke);

        // Exercise
        mockMvc.perform(post("/api/joke").content(requestBody).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Category cannot be null.");
    }
}
