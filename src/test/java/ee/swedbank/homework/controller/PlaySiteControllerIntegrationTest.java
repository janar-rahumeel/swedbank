package ee.swedbank.homework.controller;

import ee.swedbank.homework.AbstractRestControllerIntegrationTest;
import ee.swedbank.homework.controller.model.PlaySiteData;
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
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class PlaySiteControllerIntegrationTest extends AbstractRestControllerIntegrationTest {

    @Sql("/sql/testThatPlaySiteGetIsSuccessful.sql")
    @Test
    void testThatPlaySiteGetIsSuccessful() {
        // given
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        // when
        ResponseEntity<PlaySiteData> responseEntity = testRestTemplate
                .exchange("/v1/play-sites/1", HttpMethod.GET, httpEntity, PlaySiteData.class);

        // then
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        PlaySiteData playSiteData = responseEntity.getBody();
        assertThat(playSiteData, is(notNullValue()));
        assertThat(playSiteData.getId(), is(notNullValue()));
        assertThat(playSiteData.getPlaygroundId(), is(1L));
        assertThat(playSiteData.getName(), is("Play site name 1"));
        assertThat(playSiteData.getMaximumKidCapacity(), is((short) 10));
        assertThat(playSiteData.getAttractionIds(), hasItem(1L));
    }

    @Sql("/sql/testThatPlaySiteInsertIsSuccessful.sql")
    @Test
    void testThatPlaySiteInsertIsSuccessful() {
        // given
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>("{\"playgroundId\": 2, \"name\": \"Play site name 2\", \"maximumKidCapacity\": 20}", httpHeaders);

        // when
        ResponseEntity<PlaySiteData> responseEntity = testRestTemplate
                .exchange("/v1/play-sites", HttpMethod.POST, httpEntity, PlaySiteData.class);

        // then
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        PlaySiteData playSiteData = responseEntity.getBody();
        assertThat(playSiteData, is(notNullValue()));
        assertThat(playSiteData.getId(), is(notNullValue()));
        assertThat(playSiteData.getPlaygroundId(), is(2L));
        assertThat(playSiteData.getName(), is("Play site name 2"));
        assertThat(playSiteData.getMaximumKidCapacity(), is((short) 20));
    }

}