package com.dh.catalog.controller;

import com.dh.catalog.client.MovieFeign;
import com.dh.catalog.client.SerieFeign;
import com.dh.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

	@Autowired
	private CatalogService catalogService;

//	@Autowired
//	private MovieFeign movieFeign;
//
//	@Autowired
//	private SerieFeign serieFeign;

	@GetMapping("/online/{popularidad}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<GetSugerenciaByPopularidadResponse> getSugerenciaByPopularidadOnline(@PathVariable String popularidad) {
		return ResponseEntity.ok(catalogService.getSugerenciaByPopularidadOnline(popularidad));
	}

	@GetMapping("/offline/{popularidad}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<GetSugerenciaByPopularidadResponse> getSugerenciaByPopularidadOffline(@PathVariable String popularidad) {
		return ResponseEntity.ok(catalogService.getSugerenciaByPopularidadOffline(popularidad));
	}

//	@GetMapping("/movies/{genre}")
//	ResponseEntity<List<MovieFeign.Movie>> getMoviesGenre(@PathVariable String genre) {
//		return ResponseEntity.ok(movieFeign.getMovieByGenre(genre));
//	}
//
//	@GetMapping("/series/{genre}")
//	ResponseEntity<List<SerieFeign.Serie>> getSeriesGenre(@PathVariable String genre) {
//		return ResponseEntity.ok(serieFeign.getSerieByGenre(genre));
//	}

}
