package com.galvanize.repository;

import com.galvanize.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    Movie findMovieByImdbId(String imdbId);
    Movie findTwoMovieByImdbId(String imdbId);

}









