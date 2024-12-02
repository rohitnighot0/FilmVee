package com.filmvee.moviefinder.controller;

import com.filmvee.moviefinder.domain.service.SearchMovieService;
import com.filmvee.moviefinder.entities.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/filmvee")
public class SearchMovieResource {
    @Autowired
    private SearchMovieService searchMovieService;
    @GetMapping("/fetch/movie-name")
    ResponseEntity<List<Movie>> searchMovieName(@RequestParam String keyword) {
        List<Movie> movies = searchMovieService.searchMovieByName(keyword);
        if (movies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(movies);
    }
}
