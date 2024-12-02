package com.filmvee.moviefinder.domain.service;

import com.filmvee.moviefinder.entities.Movie;
import com.filmvee.moviefinder.repo.MovieRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetMovieDetailsService {
    @Autowired
    private MovieRepo movieRepository;
    public List<Movie> retrieveMovieList() {
        return movieRepository.findAll();
    }
}
