package ee.swedbank.homework.controller.mapper;

import ee.swedbank.homework.controller.model.PlaySiteData;
import ee.swedbank.homework.entity.Attraction;
import ee.swedbank.homework.entity.PlaySite;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class PlaySiteMapper {

    @Mapping(target = "playgroundId", source = "playground.id")
    public abstract PlaySiteData map(PlaySite playSite);

    @AfterMapping
    protected void afterMapping(
            PlaySite playSite,
            @MappingTarget PlaySiteData.PlaySiteDataBuilder playSiteDataBuilder) {
        Set<Long> attractionIds = playSite.getAttractions()
                .stream()
                .map(Attraction::getId)
                .collect(Collectors.toSet());
        playSiteDataBuilder.attractionIds(attractionIds);
    }

}
