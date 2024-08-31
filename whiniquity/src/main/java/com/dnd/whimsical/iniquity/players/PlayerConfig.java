package com.dnd.whimsical.iniquity.players;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository) {
        return args -> {
            Players darius = new Players("Darius", "Amari Hovington", "Human", "Monk", null, 21, 2);
            Players shaun = new Players("Shaun", "Booker 'Mouse' Bucha", "Human", "Fighter", null, 32, 2);
            Players aminah = new Players("Aminah Rasheed", "Techno", "Dark Elf", "Artficer", "Alchemist", 27, 2);
            Players gean = new Players("Gean Jackson", "Jahka Conto", "Human", "Monk", "Way of Shadow", 29, 2);

            repository.saveAll(List.of(darius, shaun, aminah, gean));

        };
    }
}
