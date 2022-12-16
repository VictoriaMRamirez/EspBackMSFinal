package com.dh.catalog.repository;

import com.dh.catalog.model.entity.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepositoryMongo extends MongoRepository<Serie, Long> {

    List<Serie> findByGenre(String genre);
}
