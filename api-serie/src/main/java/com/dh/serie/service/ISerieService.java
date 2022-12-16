package com.dh.serie.service;

import com.dh.serie.model.dto.SerieDTO;
import com.dh.serie.model.entity.Serie;

import java.util.List;

public interface ISerieService {
    public SerieDTO save(SerieDTO serieDTO);
    public List<SerieDTO> findByGenre(String genre);
    public List<SerieDTO> getAll();
}
