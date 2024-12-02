package com.filmvee.moviefinder.domain.service;

import com.filmvee.moviefinder.entities.Movie;
import com.filmvee.moviefinder.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddMovieService {
    @Autowired
    private MovieRepo movieRepo;

    public ResponseEntity<Object> postMovie(Movie movie) {
        if (movieRepo.existsByMovieName(movie.getMovieName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Movie postedMovie = movieRepo.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(postedMovie);
    }
}
