package ee.swedbank.homework.repository;

import ee.swedbank.homework.entity.PlaySite;
import org.springframework.data.repository.CrudRepository;

public interface PlaySiteRepository extends CrudRepository<PlaySite, Long>, CustomPlaySiteRepository {
}
