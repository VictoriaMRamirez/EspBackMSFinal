package com.dh.movie.service;

import com.dh.movie.model.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    MovieDTO save(MovieDTO movieDTO);
    List<MovieDTO> findByGenre(String genre);
    List<MovieDTO> getAll();
}
