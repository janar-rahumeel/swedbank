package ee.swedbank.homework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Immutable;

import java.time.LocalDateTime;

@Table(name = "KID_PLAY_SITE_VISIT")
@Setter
@Getter
@Entity
@Builder
@ToString
@Immutable
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KidPlaySiteVisit extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_KID_PLAY_SITE_VISIT")
    @SequenceGenerator(name = "SEQ_KID_PLAY_SITE_VISIT", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "KID_ID")
    private Kid kid;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PLAY_SITE_ID")
    private PlaySite playSite;

    @NotNull
    @Enumerated(EnumType.STRING)
    private KidPlaySiteVisitStatus status;

    @Column(name = "START_AT")
    @NotNull
    private LocalDateTime startAt;

    @Column(name = "END_AT")
    private LocalDateTime endAt;

}
