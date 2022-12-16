package com.dh.movie.event;

import com.dh.movie.config.RabbitMQConfig;
import com.dh.movie.model.entity.Movie;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewMovieEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public NewMovieEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void execute(Movie newMovie) {
//        NewMovieEventProducer.Data data= new NewMovieEventProducer.Data();
//        BeanUtils.copyProperties(newMovie,data.getMovie());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_MOVIE, newMovie);
    }

//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class Data implements Serializable {
//
//        @Serial
//        private static final long serialVersionUID = 1L;
//        private Data.MovieDto movie= new Data.MovieDto();
//
//        @Getter
//        @Setter
//        @NoArgsConstructor
//        @AllArgsConstructor
//        public static class MovieDto implements Serializable {
//
//            @Serial
//            private static final long serialVersionUID = 1L;
//            private Long movieId;
//            private String name;
//            private String genre;
//            private String urlStream;
//            private Integer mgCount;
//        }
//    }
}
