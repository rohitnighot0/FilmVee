package com.filmvee.moviefinder.repo;

import com.filmvee.moviefinder.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    List<Movie> findByMovieNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String movieName, String description);

    boolean existsByMovieName(String movieName);
}
