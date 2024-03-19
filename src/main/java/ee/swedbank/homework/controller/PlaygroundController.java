package ee.swedbank.homework.controller;

import ee.swedbank.homework.controller.mapper.PlaygroundMapper;
import ee.swedbank.homework.controller.model.PlaygroundData;
import ee.swedbank.homework.entity.Playground;
import ee.swedbank.homework.service.PlaygroundService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional(readOnly = true)
@RestController
@RequestMapping(path = "/v1/playgrounds")
@RequiredArgsConstructor
public class PlaygroundController {

    private static final PlaygroundMapper MAPPER = Mappers.getMapper(PlaygroundMapper.class);

    private final PlaygroundService playgroundService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaygroundData> get(@PathVariable("id") Long id) {
        Playground playground = playgroundService.get(id);
        PlaygroundData playgroundData = MAPPER.map(playground);
        return ResponseEntity.ok(playgroundData);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<PlaygroundData> insert(@Valid @RequestBody PlaygroundData newPlaygroundData) {
        Playground playground = playgroundService.insert(newPlaygroundData);
        PlaygroundData playgroundData = MAPPER.map(playground);
        return ResponseEntity.ok(playgroundData);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<PlaygroundData> update(@PathVariable("id") Long id, @Valid @RequestBody PlaygroundData updatedPlaygroundData) {
        Playground playground = playgroundService.update(id, updatedPlaygroundData);
        PlaygroundData playgroundData = MAPPER.map(playground);
        return ResponseEntity.ok(playgroundData);
    }

}
