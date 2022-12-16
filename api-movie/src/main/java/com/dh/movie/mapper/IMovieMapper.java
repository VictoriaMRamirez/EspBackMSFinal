package com.dh.movie.mapper;

import com.dh.movie.model.entity.Movie;
import com.dh.movie.model.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IMovieMapper {
    Movie toEntity(MovieDTO movieDTO);
    MovieDTO toDTO(Movie movieEntity);

    List<Movie> toEntity(Iterable<MovieDTO> movieDTOS);
    List<MovieDTO> toDTO(Iterable<Movie> movieEntities);
}
