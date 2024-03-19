package ee.swedbank.homework.repository;

import ee.swedbank.homework.entity.PlaySiteUtilizationInfo;

public interface CustomPlaySiteRepository {

    PlaySiteUtilizationInfo getPlaySiteUtilizationInfo(Long id);

}
