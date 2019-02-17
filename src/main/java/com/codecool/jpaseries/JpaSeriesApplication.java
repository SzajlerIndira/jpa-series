package com.codecool.jpaseries;


import com.codecool.jpaseries.entity.Episode;
import com.codecool.jpaseries.entity.Season;
import com.codecool.jpaseries.entity.SeasonTitle;
import com.codecool.jpaseries.entity.Series;
import com.codecool.jpaseries.repository.EpisodeRepository;
import com.codecool.jpaseries.repository.SeasonRepository;
import com.codecool.jpaseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaSeriesApplication {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaSeriesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Series gameOfThrones = Series.builder()
                    .title("Game of Thrones")
                    .genre(Arrays.asList("Action", "Adventure", "Drama"))
                    .build();

            seriesRepository.save(gameOfThrones);

            Season season1 = Season.builder()
                    .seasonTitle(SeasonTitle.SEASON_1)
                    .releaseYear(2011)
                    .build();
            seasonRepository.save(season1);

            Season season2 = Season.builder()
                    .seasonTitle(SeasonTitle.SEASON_2)
                    .releaseYear(2012)
                    .build();
            seasonRepository.save(season2);

            List<Episode> episodes = new ArrayList<Episode>();

            Episode winterIsComing = Episode.builder()
                    .title("Winter is coming")
                    .season(season1)
                    .rate(9.0)
                    .build();

            episodes.add(winterIsComing);

            Episode theKingsroad = Episode.builder()
                    .title("The Kingsroad")
                    .season(season1)
                    .rate(8.8)
                    .build();

            episodes.add(theKingsroad);

            Episode lordSnow = Episode.builder()
                    .title("Lord Snow")
                    .season(season1)
                    .rate(8.7)
                    .build();

            episodes.add(lordSnow);

            Episode criplles = Episode.builder()
                    .title("Cripples, Bastards, and Broken Things")
                    .season(season1)
                    .rate(8.8)
                    .build();

            episodes.add(criplles);


            Episode theWolfAndTheLion = Episode.builder()
                    .title("The Wolf and the Lion")
                    .season(season1)
                    .rate(9.1)
                    .build();

            episodes.add(theWolfAndTheLion);


            Episode aGoldenCrown = Episode.builder()
                    .title("A Golden Crown")
                    .season(season1)
                    .rate(9.2)
                    .build();

            episodes.add(aGoldenCrown);


            Episode youWinOrYouDie = Episode.builder()
                    .title("You Win or You Die")
                    .season(season1)
                    .rate(9.3)
                    .build();

            episodes.add(youWinOrYouDie);


            Episode thePointyEnd = Episode.builder()
                    .title("The Pointy End")
                    .season(season1)
                    .rate(9.1)
                    .build();

            episodes.add(thePointyEnd);


            Episode baelor = Episode.builder()
                    .title("Baelor")
                    .season(season1)
                    .rate(9.6)
                    .build();

            episodes.add(baelor);


            Episode fireAndBlood = Episode.builder()
                    .title("Fire and Blood")
                    .season(season1)
                    .rate(9.1)
                    .build();

            episodes.add(fireAndBlood);


            episodeRepository.saveAll(episodes);


        };
    }

}

