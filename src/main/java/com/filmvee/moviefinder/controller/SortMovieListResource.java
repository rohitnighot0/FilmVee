package com.filmvee.moviefinder.controller;

import com.filmvee.moviefinder.domain.service.SortMovieListService;
import com.filmvee.moviefinder.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmvee")
public class SortMovieListResource {
    @Autowired
    private SortMovieListService sortMovieListService;
    @GetMapping("/sort/movie-list")
    ResponseEntity<List<Movie>> sortMovieList(@RequestParam(required = false) String movieName,
                                              @RequestParam(required = false) double rating) {
        return ResponseEntity.ok(sortMovieListService.sortMovieList(movieName, rating));
    }
}
