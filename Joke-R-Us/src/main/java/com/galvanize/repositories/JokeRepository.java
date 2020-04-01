package com.galvanize.repositories;

import com.galvanize.jokes.entities.Category;
import com.galvanize.jokes.entities.Joke;

import java.util.List;

public interface JokeRepository extends JpaRepository<Joke, Long> {
    default List<Joke> findAllByJokeContains(String sarchString) {
        return null;
    }

    List<Joke> findAllByCategory(Category category);

    @Query(value = "select * from jokes j order by RAND() LIMIT 1", nativeQuery = true)
    Joke findRandomJoke();
    }

    @Query(value = "select * from jokes j where category LIKE 71 order by RAND() LIMIT 1", nativeQuery = true)
    Joke findRandomJokeByCategory(String category);
}
