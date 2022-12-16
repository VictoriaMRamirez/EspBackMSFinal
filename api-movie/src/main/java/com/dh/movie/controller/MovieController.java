package com.dh.movie.controller;

import com.dh.movie.model.dto.MovieDTO;
import com.dh.movie.service.IMovieService;
import com.dh.movie.service.impl.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final IMovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO movieDTO) {
        return ResponseEntity.ok(movieService.save(movieDTO));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<MovieDTO>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<MovieDTO>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }
}
