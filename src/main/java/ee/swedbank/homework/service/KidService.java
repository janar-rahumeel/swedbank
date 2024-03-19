package ee.swedbank.homework.service;

import ee.swedbank.homework.controller.model.KidData;
import ee.swedbank.homework.entity.Kid;
import ee.swedbank.homework.repository.KidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KidService implements CrudSupport<Kid, KidData, Long> {

    private final KidRepository kidRepository;

    @Override
    public Kid get(Long id) {
        return kidRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No kid found: " + id));
    }

    @Override
    @Transactional
    public Kid insert(KidData kidData) {
        Kid kid = Kid.builder()
                .name(kidData.getName())
                .age(kidData.getAge())
                .ticketNumber(kidData.getTicketNumber())
                .build();
        return kidRepository.save(kid);
    }

}
