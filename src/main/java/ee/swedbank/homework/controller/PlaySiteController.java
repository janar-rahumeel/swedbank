package ee.swedbank.homework.controller;

import ee.swedbank.homework.controller.mapper.PlaySiteMapper;
import ee.swedbank.homework.controller.model.CurrentUtilizationData;
import ee.swedbank.homework.controller.model.PlaySiteData;
import ee.swedbank.homework.entity.PlaySite;
import ee.swedbank.homework.service.PlaySiteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

import java.math.BigDecimal;

@Transactional(readOnly = true)
@RestController
@RequestMapping(path = "/v1/play-sites")
@RequiredArgsConstructor
public class PlaySiteController {

    private final PlaySiteMapper playSiteMapper;
    private final PlaySiteService playSiteService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlaySiteData> get(@PathVariable("id") Long id) {
        PlaySite playSite = playSiteService.get(id);
        PlaySiteData playSiteData = playSiteMapper.map(playSite);
        return ResponseEntity.ok(playSiteData);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<PlaySiteData> insert(@Valid @RequestBody PlaySiteData newPlaySiteData) {
        PlaySite playSite = playSiteService.insert(newPlaySiteData);
        PlaySiteData playSiteData = playSiteMapper.map(playSite);
        return ResponseEntity.ok(playSiteData);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<PlaySiteData> update(@PathVariable("id") Long id, @Valid @RequestBody PlaySiteData updatedPlaySiteData) {
        PlaySite playSite = playSiteService.update(id, updatedPlaySiteData);
        PlaySiteData playSiteData = playSiteMapper.map(playSite);
        return ResponseEntity.ok(playSiteData);
    }

    @GetMapping(value = "/{id}/current-utilization", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<CurrentUtilizationData> currentUtilization(@PathVariable("id") Long id) {
        BigDecimal currentUtilizationPercentage = playSiteService.resolveCurrentUtilizationPercentage(id);
        return ResponseEntity.ok(CurrentUtilizationData.builder().percentage(currentUtilizationPercentage).build());
    }

}
