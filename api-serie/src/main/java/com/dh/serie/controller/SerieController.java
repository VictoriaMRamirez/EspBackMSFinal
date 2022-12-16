package com.dh.serie.controller;

import com.dh.serie.model.dto.SerieDTO;
import com.dh.serie.service.ISerieService;
import com.dh.serie.service.impl.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {

    private final ISerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<SerieDTO> create(@RequestBody SerieDTO serieDTO) {
        return ResponseEntity.ok(serieService.save(serieDTO));
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<SerieDTO>> getAll() {
        return ResponseEntity.ok(serieService.getAll());
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<SerieDTO>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.findByGenre(genre));
    }
}
