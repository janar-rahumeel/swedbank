package ee.swedbank.homework.controller;

import ee.swedbank.homework.AbstractRestControllerIntegrationTest;
import ee.swedbank.homework.controller.model.PlaygroundData;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class PlaygroundControllerIntegrationTest extends AbstractRestControllerIntegrationTest {

    @Test
    void testThatPlaygroundInsertIsSuccessful() {
        // given
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>("{\"name\": \"Playground name 1\"}", httpHeaders);

        // when
        ResponseEntity<PlaygroundData> responseEntity = testRestTemplate
                .exchange("/v1/playgrounds", HttpMethod.POST, httpEntity, PlaygroundData.class);

        // then
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        PlaygroundData playgroundData = responseEntity.getBody();
        assertThat(playgroundData, is(notNullValue()));
        assertThat(playgroundData.getId(), is(notNullValue()));
        assertThat(playgroundData.getName(), is("Playground name 1"));
    }

}