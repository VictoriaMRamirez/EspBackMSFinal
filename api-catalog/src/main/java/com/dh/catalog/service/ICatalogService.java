package com.dh.catalog.service;

import com.dh.catalog.model.dto.CatalogDTO;
import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.dto.SerieDTO;

public interface ICatalogService {
    CatalogDTO getCatalogOnline(String genre) throws Exception;
    CatalogDTO getCatalogOffline(String genre);
    CatalogDTO getAll();
    void saveNewMovie(MovieDTO movieDTO);
    void saveNewSerie(SerieDTO serieDTO);
}
