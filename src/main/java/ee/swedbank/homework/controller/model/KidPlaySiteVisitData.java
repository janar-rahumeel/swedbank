package ee.swedbank.homework.controller.model;

import ee.swedbank.homework.entity.Kid;
import ee.swedbank.homework.entity.KidPlaySiteVisitStatus;
import ee.swedbank.homework.entity.PlaySite;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KidPlaySiteVisitData {

    private Long id;

    @NotNull
    private Long kidId;

    @NotNull
    private Long playSiteId;

    private KidPlaySiteVisitStatus status;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

}
