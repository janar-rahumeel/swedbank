package ee.swedbank.homework.service;

import ee.swedbank.homework.controller.model.KidPlaySiteVisitData;
import ee.swedbank.homework.entity.Kid;
import ee.swedbank.homework.entity.KidPlaySiteVisit;
import ee.swedbank.homework.entity.KidPlaySiteVisitStatus;
import ee.swedbank.homework.entity.PlaySite;
import ee.swedbank.homework.repository.KidPlaySiteVisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KidPlaySiteVisitService implements CrudSupport<KidPlaySiteVisit, KidPlaySiteVisitData, Long> {

    private final KidService kidService;
    private final PlaySiteService playSiteService;
    private final KidPlaySiteVisitRepository kidPlaySiteVisitRepository;

    @Override
    public KidPlaySiteVisit get(Long id) {
        return kidPlaySiteVisitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No kid play site visit found: " + id));
    }

    @Override
    public KidPlaySiteVisit insert(KidPlaySiteVisitData kidPlaySiteVisitData) {
        Kid kid = kidService.get(kidPlaySiteVisitData.getKidId());
        PlaySite playSite = playSiteService.get(kidPlaySiteVisitData.getPlaySiteId());
        KidPlaySiteVisitStatus status = resolveStatus(playSite);
        KidPlaySiteVisit kidPlaySiteVisit = KidPlaySiteVisit.builder().kid(kid).playSite(playSite).status(status).startAt(LocalDateTime.now()).build();
        return kidPlaySiteVisitRepository.save(kidPlaySiteVisit);
    }

    private KidPlaySiteVisitStatus resolveStatus(PlaySite playSite) {
        int currentlyVisitingKidCount = kidPlaySiteVisitRepository.findCurrentlyVisitingKidCount(playSite.getId());
        if (currentlyVisitingKidCount < playSite.getMaximumKidVisitingCount()) {
            return KidPlaySiteVisitStatus.PLAYING;
        }
        return KidPlaySiteVisitStatus.WAITING;
    }

    @Override
    public KidPlaySiteVisit update(Long id, KidPlaySiteVisitData kidPlaySiteVisitData) {
        KidPlaySiteVisit kidPlaySiteVisit = get(id);
        kidPlaySiteVisit.setStatus(kidPlaySiteVisitData.getStatus());
        kidPlaySiteVisit.setEndAt(kidPlaySiteVisitData.getEndAt());
        return kidPlaySiteVisit;
    }

}
