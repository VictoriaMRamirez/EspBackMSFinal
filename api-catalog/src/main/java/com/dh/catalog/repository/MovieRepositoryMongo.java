package com.dh.catalog.repository;

import com.dh.catalog.model.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositoryMongo extends MongoRepository<Movie, Long> {

    List<Movie> findByGenre(String genre);
}
