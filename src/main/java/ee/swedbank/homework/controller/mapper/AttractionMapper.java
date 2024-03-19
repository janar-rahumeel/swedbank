package ee.swedbank.homework.controller.mapper;

import ee.swedbank.homework.controller.model.AttractionData;
import ee.swedbank.homework.entity.Attraction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttractionMapper {

    AttractionData map(Attraction attraction);

}
