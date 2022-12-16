package com.dh.catalog.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@Document(collection = "Seasons")
public class Season {

    @Id
    private String seasonId = UUID.randomUUID().toString();;
    private Integer seasonNumber;
    private List<Chapter> chapters = new ArrayList<>();
}
