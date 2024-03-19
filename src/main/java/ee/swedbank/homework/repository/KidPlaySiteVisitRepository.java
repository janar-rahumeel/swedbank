package ee.swedbank.homework.repository;

import ee.swedbank.homework.entity.KidPlaySiteVisit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KidPlaySiteVisitRepository extends CrudRepository<KidPlaySiteVisit, Long> {

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM KID_PLAY_SITE_VISIT kpsv WHERE kpsv.STATUS = 'PLAYING' AND kpsv.START_AT <= NOW() AND kpsv.END_AT IS NULL AND kpsv.PLAY_SITE_ID = :playSiteId")
    int findCurrentlyVisitingKidCount(@Param("playSiteId") Long playSiteId);

}
