package ee.swedbank.homework.controller.mapper;

import ee.swedbank.homework.controller.model.KidData;
import ee.swedbank.homework.entity.Kid;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KidMapper {

    KidData map(Kid kid);

}
