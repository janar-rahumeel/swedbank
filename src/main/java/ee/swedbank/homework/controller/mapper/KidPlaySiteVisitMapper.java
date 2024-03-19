package ee.swedbank.homework.controller.mapper;

import ee.swedbank.homework.controller.model.KidPlaySiteVisitData;
import ee.swedbank.homework.entity.KidPlaySiteVisit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KidPlaySiteVisitMapper {

    @Mapping(target = "kidId", source = "kid.id")
    @Mapping(target = "playSiteId", source = "playSite.id")
    KidPlaySiteVisitData map(KidPlaySiteVisit kidPlaySiteVisit);

}
