package net.vieracode.football.config;

import net.vieracode.football.common.PositionEnum;
import net.vieracode.football.entity.Club;
import net.vieracode.football.entity.Player;
import net.vieracode.football.repository.ClubRepository;
import net.vieracode.football.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClubRepository clubRepository, PlayerRepository playerRepository) {

        return args -> {
            Club america = new Club(1l, "AMERICA","Club America");
            Club necaxa = new Club(2l, "NECAXA","Club Necaxa");
            Club chivas = new Club(3l, "CHIVAS","Chivas rayadas del Guadalajara");
            Club pumas = new Club(4l, "PUMAS","Pumas de la UNAM");
            Club cruzazul = new Club(5l, "CRUZ AZUL","Club de la Cruz Azul");

            log.info("Preloading Club" + clubRepository.save(america));
            log.info("Preloading Club" + clubRepository.save(necaxa));
            log.info("Preloading Club" + clubRepository.save(chivas));
            log.info("Preloading Club" + clubRepository.save(pumas));
            log.info("Preloading Club" + clubRepository.save(cruzazul));

            log.info("Preloading Player" + playerRepository.save(new Player(1l, 1, "Jorge", "Campos", PositionEnum.PORTERO, pumas)));
            log.info("Preloading Player" + playerRepository.save(new Player(2l, 1, "Nicolas", "Navarro", PositionEnum.PORTERO, pumas)));
            log.info("Preloading Player" + playerRepository.save(new Player(3l, 2, "Claudio", "Suarez", PositionEnum.DEFENSA, pumas)));
            log.info("Preloading Player" + playerRepository.save(new Player(4l, 4, "Rafael", "Marquez", PositionEnum.DEFENSA, chivas)));
            log.info("Preloading Player" + playerRepository.save(new Player(5l, 7, "Ramon", "Ramirez", PositionEnum.MEDIO, chivas)));
            log.info("Preloading Player" + playerRepository.save(new Player(6l, 8, "Alberto", "Garcia Azpe", PositionEnum.MEDIO, necaxa)));
            log.info("Preloading Player" + playerRepository.save(new Player(7l, 10, "Luis", "Garcia", PositionEnum.DELANTERO, pumas)));
            log.info("Preloading Player" + playerRepository.save(new Player(8l, 15, "Luis", "Hernandez", PositionEnum.DELANTERO, pumas)));
        };
    }
}
