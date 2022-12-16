package com.dh.catalog.event;

import com.dh.catalog.configuration.RabbitMQConfig;
import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.service.ICatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewMovieEventConsumer {

    private ICatalogService catalogService;

    public NewMovieEventConsumer(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_SERIE)
    public void newMovieReceived(MovieDTO movieDTO) {
        catalogService.saveNewMovie(movieDTO);
    }
}
