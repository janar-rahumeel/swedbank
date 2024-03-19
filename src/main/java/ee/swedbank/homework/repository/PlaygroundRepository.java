package ee.swedbank.homework.repository;

import ee.swedbank.homework.entity.Playground;
import org.springframework.data.repository.CrudRepository;

public interface PlaygroundRepository extends CrudRepository<Playground, Long> {
}
