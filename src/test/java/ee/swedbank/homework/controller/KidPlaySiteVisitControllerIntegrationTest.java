package ee.swedbank.homework.controller;

import ee.swedbank.homework.AbstractRestControllerIntegrationTest;
import ee.swedbank.homework.controller.model.KidPlaySiteVisitData;
import ee.swedbank.homework.entity.KidPlaySiteVisitStatus;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class KidPlaySiteVisitControllerIntegrationTest extends AbstractRestControllerIntegrationTest {

    @Sql("/sql/testThatKidPlaySiteVisitInsertIsSuccessful.sql")
    @Test
    void testThatKidPlaySiteVisitInsertIsSuccessful() {
        // given
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>("{\"kidId\": 1, \"playSiteId\": 1}", httpHeaders);

        // when
        ResponseEntity<KidPlaySiteVisitData> responseEntity = testRestTemplate
                .exchange("/v1/kid-play-site-visits", HttpMethod.POST, httpEntity, KidPlaySiteVisitData.class);

        // then
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        KidPlaySiteVisitData kidPlaySiteVisitData = responseEntity.getBody();
        assertThat(kidPlaySiteVisitData, is(notNullValue()));
        assertThat(kidPlaySiteVisitData.getId(), is(notNullValue()));
        assertThat(kidPlaySiteVisitData.getStatus(), is(KidPlaySiteVisitStatus.WAITING));
    }

}