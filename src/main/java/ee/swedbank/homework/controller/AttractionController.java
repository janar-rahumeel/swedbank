package ee.swedbank.homework.controller;

import ee.swedbank.homework.controller.mapper.AttractionMapper;
import ee.swedbank.homework.controller.model.AttractionData;
import ee.swedbank.homework.entity.Attraction;
import ee.swedbank.homework.service.AttractionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional(readOnly = true)
@RestController
@RequestMapping(path = "/v1/attractions")
@RequiredArgsConstructor
public class AttractionController {

    private static final AttractionMapper MAPPER = Mappers.getMapper(AttractionMapper.class);

    private final AttractionService attractionService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttractionData> get(@PathVariable("id") Long id) {
        Attraction attraction = attractionService.get(id);
        AttractionData attractionData = MAPPER.map(attraction);
        return ResponseEntity.ok(attractionData);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<AttractionData> insert(@Valid @RequestBody AttractionData newAttractionData) {
        Attraction attraction = attractionService.insert(newAttractionData);
        AttractionData attractionData = MAPPER.map(attraction);
        return ResponseEntity.ok(attractionData);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<AttractionData> update(@PathVariable("id") Long id, @Valid @RequestBody AttractionData updatedAttractionData) {
        Attraction attraction = attractionService.update(id, updatedAttractionData);
        AttractionData attractionData = MAPPER.map(attraction);
        return ResponseEntity.ok(attractionData);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        attractionService.delete(id);
        return ResponseEntity.ok().build();
    }

}
