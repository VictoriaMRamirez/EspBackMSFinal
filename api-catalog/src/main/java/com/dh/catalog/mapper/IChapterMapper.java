package com.dh.catalog.mapper;

import com.dh.catalog.model.dto.ChapterDTO;
import com.dh.catalog.model.entity.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IChapterMapper {
    Chapter toEntity(ChapterDTO chapterDTO);
    ChapterDTO toDTO(Chapter chapterEntity);

    List<Chapter> toEntity(Iterable<ChapterDTO> chapterDTOS);
    List<ChapterDTO> toDTO(Iterable<Chapter> chapterEntities);
}
