package com.dh.catalog.client;

import com.dh.catalog.model.dto.SerieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-serie")
public interface ISerieFeign {

    @GetMapping("/api/v1/series/{genre}")
    List<SerieDTO> getSerieByGenre(@PathVariable(value = "genre") String genre);
}
