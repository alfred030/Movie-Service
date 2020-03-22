package com.galvanize.controllers;


        import com.galvanize.entites.Person;
        import com.jayway.jsonpath.JsonPath;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.http.MediaType;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.constraints.Null;
        import java.time.LocalDate;
        import java.util.List;
        import java.util.Scanner;

        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
        import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestController
@RequestMapping("/api")

@SpringBootTest
@AutoConfigureMockMvc
public class HelloRestControllersTest {

    @Autowired
    MockMvc mvc;

    public Person createPerson(@RequestParam String name, @RequestParam String email, @RequestParam LocalDate birthDate, @RequestParam Long id) {
        return new Person(name, email, birthDate, id);
    }

    /*** CREATE ***/
    @GetMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return person;
    }

    @GetMapping("/api")
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @Test
    void helloRegGetReturnsPerson() throws Exception {
        String url = "/hello?name=rob&birthDate=11/16/1962&email=rob.wing@galvanize.com";
        mvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rob.wing@galvanize.com")))
                .andExpect(jsonPath("$.age").value(57));
    }

    @Test
    void helloRegPostReturnsPerson() throws Exception {
        String json = "{\"name\":\"Rob\",\"birthDate\":\"1962-11-16\",\"email\":\"rob.wing@galvanize.com\"}";
        mvc.perform(post("/hello")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(new MediaType[]{MediaType.APPLICATION_JSON})
        )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("rob.wing@galvanize.com")))
                .andExpect(jsonPath("$.age").value(57));
    }
}
