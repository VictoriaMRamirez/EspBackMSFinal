package com.dh.catalog.service.impl;

import com.dh.catalog.client.IMovieFeign;
import com.dh.catalog.client.ISerieFeign;
import com.dh.catalog.exception.CircuitBreakerException;
import com.dh.catalog.mapper.IMovieMapper;
import com.dh.catalog.mapper.ISerieMapper;
import com.dh.catalog.model.dto.CatalogDTO;
import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.dto.SerieDTO;
import com.dh.catalog.model.entity.Movie;
import com.dh.catalog.model.entity.Serie;
import com.dh.catalog.repository.MovieRepositoryMongo;
import com.dh.catalog.repository.SerieRepositoryMongo;
import com.dh.catalog.service.ICatalogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogService implements ICatalogService {

    @Inject
    private IMovieMapper movieMapper;

    @Inject
    private ISerieMapper serieMapper;

    private final MovieRepositoryMongo movieRepositoryMongo;
    private final SerieRepositoryMongo serieRepositoryMongo;
    private final IMovieFeign movieFeign;
    private final ISerieFeign serieFeign;

    public CatalogService(MovieRepositoryMongo movieRepositoryMongo, SerieRepositoryMongo serieRepositoryMongo, IMovieFeign movieFeign, ISerieFeign serieFeign) {
        this.movieRepositoryMongo = movieRepositoryMongo;
        this.serieRepositoryMongo = serieRepositoryMongo;
        this.movieFeign = movieFeign;
        this.serieFeign = serieFeign;
    }

    @CircuitBreaker(name = "catalog", fallbackMethod = "onlineCatalogFallbackMethod" )
    @Retry(name = "catalog")
    public CatalogDTO getCatalogOnline(String genre) throws Exception{
        String genreToLowerCase = genre.toLowerCase();
        List<MovieDTO> movieDTOS = movieFeign.getMovieByGenre(genreToLowerCase);
        List<SerieDTO> serieDTOS = serieFeign.getSerieByGenre(genreToLowerCase);
        return new CatalogDTO(genre, movieDTOS, serieDTOS);
    }

    public CatalogDTO getCatalogOffline(String genre) {
        String genreToLowerCase = genre.toLowerCase();
        List<Movie> movies = movieRepositoryMongo.findByGenre(genreToLowerCase);
        List<Serie> series = serieRepositoryMongo.findByGenre(genreToLowerCase);

        Map<String, Object> result = converterDataToDTO(movies, series);

        return new CatalogDTO(genreToLowerCase, (List<MovieDTO>) result.get("movies"), (List<SerieDTO>) result.get("series"));
    }

    public CatalogDTO getAll() {
        List<Movie> movies = movieRepositoryMongo.findAll();
        List<Serie> series = serieRepositoryMongo.findAll();

        Map<String, Object> result = converterDataToDTO(movies, series);

        return new CatalogDTO("all", (List<MovieDTO>) result.get("movies"), (List<SerieDTO>) result.get("series"));
    }

    public void saveNewMovie(MovieDTO movieDTO){
        MovieDTO newMovieDTO = new MovieDTO(movieDTO.movieId(), movieDTO.name().toLowerCase(), movieDTO.genre(), movieDTO.urlStream());
        movieRepositoryMongo.save(movieMapper.toEntity(newMovieDTO));
    }

    public void saveNewSerie(SerieDTO serieDTO){
        SerieDTO newSerieDTO = new SerieDTO(serieDTO.serieId(), serieDTO.name().toLowerCase(), serieDTO.genre(), serieDTO.seasons());
        serieRepositoryMongo.save(serieMapper.toEntity(newSerieDTO));
    }

    /**
     * En caso de un estado abierto opté por devolver una excepción con un mensaje informativo
     * para el cliente y la causa del error correspondiente.
     * */
    private CatalogDTO onlineCatalogFallbackMethod(Exception ex) throws CircuitBreakerException {
        throw new CircuitBreakerException(ex.getMessage() + "\n Cause: " + ex.getCause());
    }

    private Map<String, Object> converterDataToDTO(List<Movie> movies, List<Serie> series) {
        HashMap<String, Object> res = new HashMap<>();

        if(movies.isEmpty() && series.isEmpty()) {
            res.put("info", "Both lists are empty");
            res.put("movies", List.of());
            res.put("series", List.of());
        }else{
            res.put("movies", movieMapper.toDTO(movies));
            res.put("series", serieMapper.toDTO(series));
        }

        return res;
    }
}
