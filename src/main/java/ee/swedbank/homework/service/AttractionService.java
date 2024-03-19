package ee.swedbank.homework.service;

import ee.swedbank.homework.controller.model.AttractionData;
import ee.swedbank.homework.entity.Attraction;
import ee.swedbank.homework.entity.PlaySite;
import ee.swedbank.homework.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AttractionService implements CrudSupport<Attraction, AttractionData, Long> {

    private final PlaySiteService playSiteService;
    private final AttractionRepository attractionRepository;

    @Override
    public Attraction get(Long id) {
        return attractionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No attraction found: " + id));
    }

    @Override
    @Transactional
    public Attraction insert(AttractionData attractionData) {
        PlaySite playSite = playSiteService.get(attractionData.getPlaySiteId());
        Attraction attraction = Attraction.builder()
                .playSite(playSite)
                .serialNumber(attractionData.getSerialNumber())
                .type(attractionData.getType())
                .build();
        return attractionRepository.save(attraction);
    }

    @Override
    @Transactional
    public Attraction update(Long id, AttractionData attractionData) {
        Attraction attraction = get(id);
        PlaySite playSite = playSiteService.get(attractionData.getPlaySiteId());
        attraction.setPlaySite(playSite);
        attraction.setSerialNumber(attractionData.getSerialNumber());
        attraction.setType(attractionData.getType());
        return attraction;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        attractionRepository.deleteById(id);
    }

}
