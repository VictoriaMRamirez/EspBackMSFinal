package com.dh.catalog.model.dto;

import java.util.List;

public record CatalogDTO(String genre, List<MovieDTO> movies, List<SerieDTO> series) {}
