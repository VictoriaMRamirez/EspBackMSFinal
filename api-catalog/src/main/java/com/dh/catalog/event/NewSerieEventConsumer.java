package com.dh.catalog.event;

import com.dh.catalog.configuration.RabbitMQConfig;
import com.dh.catalog.model.dto.SerieDTO;
import com.dh.catalog.service.ICatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewSerieEventConsumer {

    private ICatalogService catalogService;

    public NewSerieEventConsumer(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_SERIE)
    public void newSerieReceived(SerieDTO serieDTO) {
        catalogService.saveNewSerie(serieDTO);
    }
}
