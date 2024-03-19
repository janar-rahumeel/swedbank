package ee.swedbank.homework.repository;

import ee.swedbank.homework.entity.PlaySiteUtilizationInfo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomPlaySiteRepositoryImpl implements CustomPlaySiteRepository {

    private final EntityManager entityManager;

    @Override
    public PlaySiteUtilizationInfo getPlaySiteUtilizationInfo(Long id) {
        return entityManager.createQuery("select new ee.swedbank.homework.entity.PlaySiteUtilizationInfo(ps.maximumKidVisitingCount, count(kpsv)) from KidPlaySiteVisit kpsv left join kpsv.playSite ps where kpsv.status = 'PLAYING' and kpsv.endAt is null and ps.id = :id", PlaySiteUtilizationInfo.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
