package com.dh.serie.mapper;

import com.dh.serie.model.dto.SeasonDTO;
import com.dh.serie.model.entity.Season;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ISeasonMapper {
    Season toEntity(SeasonDTO seasonDTO);
    SeasonDTO toDTO(Season seasonEntity);

    List<Season> toEntity(Iterable<SeasonDTO> seasonDTOS);
    List<SeasonDTO> toDTO(Iterable<Season> seasonEntities);
}
