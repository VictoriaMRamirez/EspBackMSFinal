package com.dh.serie.service.impl;

import com.dh.serie.event.NewSerieEventProducer;
import com.dh.serie.mapper.ISerieMapper;
import com.dh.serie.model.dto.SerieDTO;
import com.dh.serie.model.entity.Serie;
import com.dh.serie.repository.SerieRepository;
import com.dh.serie.service.ISerieService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SerieService implements ISerieService {

    @Inject
    private ISerieMapper mapper;

    private final SerieRepository serieRepository;
    private final NewSerieEventProducer newSerieEventProducer;

    public SerieService(SerieRepository serieRepository, NewSerieEventProducer newSerieEventProducer) {
        this.serieRepository = serieRepository;
        this.newSerieEventProducer = newSerieEventProducer;
    }

    public SerieDTO save(SerieDTO serieDTO) {
        Serie serie = mapper.toEntity(serieDTO);
        serieRepository.save(serie);
        newSerieEventProducer.execute(serie);
        return mapper.toDTO(serie);
    }

    public List<SerieDTO> findByGenre(String genre) {
        List<Serie> series = serieRepository.findByGenre(genre);
        return mapper.toDTO(series);
    }

    public List<SerieDTO> getAll() {
        List<Serie> series = serieRepository.findAll();
        return mapper.toDTO(series);
    }
}
