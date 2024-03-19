package ee.swedbank.homework.service;

import ee.swedbank.homework.controller.model.PlaySiteData;
import ee.swedbank.homework.entity.PlaySite;
import ee.swedbank.homework.entity.Playground;
import ee.swedbank.homework.repository.PlaySiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .maximumKidCapacity(playSiteData.getMaximumKidCapacity())
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
        playSite.setMaximumKidCapacity(playSiteData.getMaximumKidCapacity());
        return playSite;
    }

}
