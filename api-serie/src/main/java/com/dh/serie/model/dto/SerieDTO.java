package com.dh.serie.model.dto;

import java.util.List;

public record SerieDTO(String serieId, String name, String genre, List<SeasonDTO> seasons) {}
