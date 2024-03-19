package ee.swedbank.homework.repository;

import ee.swedbank.homework.entity.Attraction;
import org.springframework.data.repository.CrudRepository;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {
}
