package ee.swedbank.homework.controller;

import ee.swedbank.homework.controller.mapper.KidPlaySiteVisitMapper;
import ee.swedbank.homework.controller.model.KidPlaySiteVisitData;
import ee.swedbank.homework.entity.KidPlaySiteVisit;
import ee.swedbank.homework.service.KidPlaySiteVisitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional(readOnly = true)
@RestController
@RequestMapping(path = "/v1/kid-play-site-visits")
@RequiredArgsConstructor
public class KidPlaySiteVisitController {

    private static final KidPlaySiteVisitMapper MAPPER = Mappers.getMapper(KidPlaySiteVisitMapper.class);

    private final KidPlaySiteVisitService kidPlaySiteVisitService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<KidPlaySiteVisitData> insert(@Valid @RequestBody KidPlaySiteVisitData newKidPlaySiteVisitData) {
        KidPlaySiteVisit kidPlaySiteVisit = kidPlaySiteVisitService.insert(newKidPlaySiteVisitData);
        KidPlaySiteVisitData kidPlaySiteVisitData = MAPPER.map(kidPlaySiteVisit);
        return ResponseEntity.ok(kidPlaySiteVisitData);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<KidPlaySiteVisitData> update(@PathVariable("id") Long id, @Valid @RequestBody KidPlaySiteVisitData updatedKidPlaySiteVisitData) {
        KidPlaySiteVisit kidPlaySiteVisit = kidPlaySiteVisitService.update(id, updatedKidPlaySiteVisitData);
        KidPlaySiteVisitData kidPlaySiteVisitData = MAPPER.map(kidPlaySiteVisit);
        return ResponseEntity.ok(kidPlaySiteVisitData);
    }

}
