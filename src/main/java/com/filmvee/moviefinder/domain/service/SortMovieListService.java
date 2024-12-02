package com.filmvee.moviefinder.domain.service;

import com.filmvee.moviefinder.entities.Movie;
import com.filmvee.moviefinder.repo.MovieRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SortMovieListService {
    @Autowired
    private MovieRepo movieRepository;
    public List<Movie> sortMovieList(String movieName, double rating) {
        return movieRepository.findAll(Sort.by("movieName").ascending().and(Sort.by("rating").descending()));
    }
}
