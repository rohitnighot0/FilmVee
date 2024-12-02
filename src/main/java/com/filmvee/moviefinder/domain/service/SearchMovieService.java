package com.filmvee.moviefinder.domain.service;

import com.filmvee.moviefinder.entities.Movie;
import com.filmvee.moviefinder.repo.MovieRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SearchMovieService {
    @Autowired
    private MovieRepo movieRepository;
    public List<Movie> searchMovieByName(String keyword) {
        return movieRepository.findByMovieNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }
}
