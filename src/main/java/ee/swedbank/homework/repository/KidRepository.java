package ee.swedbank.homework.repository;

import ee.swedbank.homework.entity.Kid;
import org.springframework.data.repository.CrudRepository;

public interface KidRepository extends CrudRepository<Kid, Long> {
}
