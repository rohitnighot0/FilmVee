package com.filmvee.moviefinder.controller;

import com.filmvee.moviefinder.domain.service.GetMovieDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmvee")
@RequiredArgsConstructor
@Slf4j
public class GetMovieDetailsResource {
    @Autowired
    private GetMovieDetailsService getMovieDetailsService;

    @GetMapping("/fetch/movies-list")
    ResponseEntity<?> getMovieList() {
        return ResponseEntity.ok(getMovieDetailsService.retrieveMovieList());
    }
}
