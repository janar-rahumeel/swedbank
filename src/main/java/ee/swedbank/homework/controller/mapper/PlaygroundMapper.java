package ee.swedbank.homework.controller.mapper;

import ee.swedbank.homework.controller.model.PlaygroundData;
import ee.swedbank.homework.entity.Playground;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaygroundMapper {

    PlaygroundData map(Playground playground);

}
