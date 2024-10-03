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
            log.info("Preloading " + repository.save(new Dto("Star wars", "sci-fi")));
            log.info("Preloading " + repository.save(new Dto("Harry potter", "fantasia")));
            log.info("Preloading " + repository.save(new Dto("Joker 2", "fantasia")));
            log.info("Preloading " + repository.save(new Dto("Beetlejuice", "Terror")));
        };
    }
}
