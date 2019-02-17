package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Season;
import com.codecool.jpaseries.entity.SeasonTitle;
import com.codecool.jpaseries.entity.Series;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SeriesRepository seriesRepository;




    @Test
    public void saveOneSimple() {
        Season season2 = Season.builder()
                .releaseYear(2012)
                .seasonTitle(SeasonTitle.SEASON_1)
                .build();
        seasonRepository.save(season2);
        List<Season> seasonList =  seasonRepository.findAll();
        assertThat(seasonList).hasSize(1);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void saveUniqueFieldTwice() {
        Season season1 = Season.builder()
                .seasonTitle(SeasonTitle.SEASON_1)
                .releaseYear(2011)
                .build();
        seasonRepository.save(season1);

        Season season2 = Season.builder()
                .seasonTitle(SeasonTitle.SEASON_1)
                .releaseYear(2012)
                .build();
        seasonRepository.saveAndFlush(season2);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void titleShouldBeNotNull() {
        Season season1 = Season.builder()
                .releaseYear(2011)
                .build();
        seasonRepository.save(season1);
    }
}