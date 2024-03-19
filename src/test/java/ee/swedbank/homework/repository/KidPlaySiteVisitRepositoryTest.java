package ee.swedbank.homework.repository;

import ee.swedbank.homework.AbstractJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class KidPlaySiteVisitRepositoryTest extends AbstractJpaTest {

    @Autowired
    private KidPlaySiteVisitRepository kidPlaySiteVisitRepository;

    @Sql("/sql/testThatFindTotalVisitCountIsSuccessful.sql")
    @Test
    void testThatFindTotalVisitCountIsSuccessful() {
        // given
        LocalDate day = LocalDate.of(2024, 3, 19);

        // when
        int totalVisitCount = kidPlaySiteVisitRepository.findTotalVisitCount(day);

        // then
        assertThat(totalVisitCount, is(1));
    }
}