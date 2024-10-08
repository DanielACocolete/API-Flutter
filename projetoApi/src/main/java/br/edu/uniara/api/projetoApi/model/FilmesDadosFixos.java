package br.edu.uniara.api.projetoApi.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilmesDadosFixos {
    private static final Logger log = LoggerFactory.getLogger(FilmesDadosFixos.class);

    @Bean
    CommandLineRunner initDatabase(Repository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Dto("Star wars", "Sci-fi", "https://uauposters.com.br/media/catalog/product/cache/1/thumbnail/800x930/9df78eab33525d08d6e5fb8d27136e95/1/1/113720160405-uau-posters-filmes-star-wars-force-awekens.jpg")));
            log.info("Preloading " + repository.save(new Dto("Harry potter", "Fantasia", "")));
            log.info("Preloading " + repository.save(new Dto("Joker 2", "Drama", "")));
            log.info("Preloading " + repository.save(new Dto("Beetlejuice", "Terror", "")));
        };
    }
}
