package com.dh.catalog.mapper;

import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.entity.Movie;
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
