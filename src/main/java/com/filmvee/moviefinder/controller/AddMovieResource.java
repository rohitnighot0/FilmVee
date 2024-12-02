package com.filmvee.moviefinder.controller;

import com.filmvee.moviefinder.domain.service.AddMovieService;
import com.filmvee.moviefinder.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmvee")
public class AddMovieResource {
    @Autowired
    private AddMovieService addMovieService;
    @PostMapping("/movie/add")
    public ResponseEntity<Object> addMovie(@RequestBody Movie movie) {
        return addMovieService.postMovie(movie);
    }
}
