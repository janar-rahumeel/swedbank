package ee.swedbank.homework.controller;

import ee.swedbank.homework.controller.mapper.KidMapper;
import ee.swedbank.homework.controller.model.KidData;
import ee.swedbank.homework.entity.Kid;
import ee.swedbank.homework.service.KidService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional(readOnly = true)
@RestController
@RequestMapping(path = "/v1/kids")
@RequiredArgsConstructor
public class KidController {

    private static final KidMapper MAPPER = Mappers.getMapper(KidMapper.class);

    private final KidService kidService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KidData> get(@PathVariable("id") Long id) {
        Kid kid = kidService.get(id);
        KidData kidData = MAPPER.map(kid);
        return ResponseEntity.ok(kidData);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<KidData> insert(@Valid @RequestBody KidData newKidData) {
        Kid kid = kidService.insert(newKidData);
        KidData kidData = MAPPER.map(kid);
        return ResponseEntity.ok(kidData);
    }

}
