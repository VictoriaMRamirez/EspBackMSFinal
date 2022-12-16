package com.dh.catalog.mapper;

import com.dh.catalog.model.dto.SerieDTO;
import com.dh.catalog.model.entity.Serie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ISerieMapper {
    Serie toEntity(SerieDTO serieDTO);
    SerieDTO toDTO(Serie serieEntity);

    List<Serie> toEntity(Iterable<SerieDTO> serieDTOS);
    List<SerieDTO> toDTO(Iterable<Serie> serieEntities);
}
