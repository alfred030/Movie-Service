package com.galvanize.entity;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieId")
    private long movieId;
    @Column(name = "email")
    private String email;
    @Column(name = "imdbId")
    private String imdbId;
    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private long rating;
    @Column(name = "text")
    private String text;


    public Movie() {
    }

    public Movie(long reviewId, String email, String imdbId, String title, long rating, String text){
        this.movieId = movieId;
        this.email = email;
        this.imdbId = imdbId;
        this.title = title;
        this.rating = rating;
        this.text = text;
    }

    public Movie(String email, String imdbId, String title, long rating, String text){
        this.movieId = movieId;
        this.email = email;
        this.imdbId = imdbId;
        this.title = title;
        this.rating = rating;
        this.text = text;

    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId &&
                rating == movie.rating &&
                Objects.equals(email, movie.email) &&
                Objects.equals(imdbId, movie.imdbId) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(text, movie.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, email, imdbId, title, rating, text);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", email='" + email + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", text='" + text + '\'' +
                '}';
    }

    public void update(Movie newMovie) {
    }
}
