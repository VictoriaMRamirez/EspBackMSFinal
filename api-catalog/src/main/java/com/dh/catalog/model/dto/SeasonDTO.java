package com.dh.catalog.model.dto;

import java.util.List;

public record SeasonDTO(String seasonId, Integer seasonNumber, List<ChapterDTO> chapters) {}
