package com.dh.movie.service.impl;

import com.dh.movie.event.NewMovieEventProducer;
import com.dh.movie.mapper.IMovieMapper;
import com.dh.movie.model.dto.MovieDTO;
import com.dh.movie.model.entity.Movie;
import com.dh.movie.repository.MovieRepository;
import com.dh.movie.service.IMovieService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Inject
    private IMovieMapper mapper;

    private final MovieRepository movieRepository;

    private final NewMovieEventProducer newMovieEventProducer;

    public MovieService(MovieRepository movieRepository, NewMovieEventProducer newMovieEventProducer) {
        this.movieRepository = movieRepository;
        this.newMovieEventProducer = newMovieEventProducer;
    }

    public MovieDTO save(MovieDTO movieDTO) {
        Movie movie = mapper.toEntity(movieDTO);
        movieRepository.save(movie);
        newMovieEventProducer.execute(movie);
        return mapper.toDTO(movie);
    }

    public List<MovieDTO> findByGenre(String genre) {
        List<Movie> movies = movieRepository.findByGenre(genre);
        return mapper.toDTO(movies);
    }

    public List<MovieDTO> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return mapper.toDTO(movies);
    }
}
