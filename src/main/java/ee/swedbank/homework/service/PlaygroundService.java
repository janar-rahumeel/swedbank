package ee.swedbank.homework.service;

import ee.swedbank.homework.controller.model.PlaygroundData;
import ee.swedbank.homework.entity.Playground;
import ee.swedbank.homework.repository.PlaygroundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaygroundService implements CrudSupport<Playground, PlaygroundData, Long> {

    private final PlaygroundRepository playgroundRepository;

    @Override
    public Playground get(Long id) {
        return playgroundRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No playground found: " + id));
    }

    @Override
    @Transactional
    public Playground insert(PlaygroundData playgroundData) {
        Playground playground = Playground.builder()
                .name(playgroundData.getName())
                .build();
        return playgroundRepository.save(playground);
    }

    @Override
    @Transactional
    public Playground update(Long id, PlaygroundData playgroundData) {
        Playground playground = get(id);
        playground.setName(playgroundData.getName());
        return playground;
    }

}
