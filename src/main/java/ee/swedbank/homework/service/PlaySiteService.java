package ee.swedbank.homework.service;

import ee.swedbank.homework.controller.model.PlaySiteData;
import ee.swedbank.homework.entity.PlaySite;
import ee.swedbank.homework.entity.PlaySiteUtilizationInfo;
import ee.swedbank.homework.entity.Playground;
import ee.swedbank.homework.repository.PlaySiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class PlaySiteService implements CrudSupport<PlaySite, PlaySiteData, Long> {

    private final PlaygroundService playgroundService;
    private final PlaySiteRepository playSiteRepository;

    @Override
    public PlaySite get(Long id) {
        return playSiteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No play site found: " + id));
    }

    @Override
    @Transactional
    public PlaySite insert(PlaySiteData playSiteData) {
        Playground playground = playgroundService.get(playSiteData.getPlaygroundId());
        PlaySite playSite = PlaySite.builder()
                .playground(playground)
                .name(playSiteData.getName())
                .maximumKidVisitingCount(playSiteData.getMaximumKidVisitingCount())
                .build();
        return playSiteRepository.save(playSite);
    }

    @Override
    @Transactional
    public PlaySite update(Long id, PlaySiteData playSiteData) {
        PlaySite playSite = get(id);
        Playground playground = playgroundService.get(playSiteData.getPlaygroundId());
        playSite.setPlayground(playground);
        playSite.setName(playSiteData.getName());
        playSite.setMaximumKidVisitingCount(playSiteData.getMaximumKidVisitingCount());
        return playSite;
    }

    public BigDecimal resolveCurrentUtilizationPercentage(Long id) {
        PlaySiteUtilizationInfo playSiteUtilizationInfo = playSiteRepository.getPlaySiteUtilizationInfo(id);
        return BigDecimal.valueOf(playSiteUtilizationInfo.getCurrentKidVisitingCount()).divide(BigDecimal.valueOf(playSiteUtilizationInfo.getMaximumKidVisitingCount()), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    }

}
