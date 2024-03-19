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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Immutable;

@Table(name = "ATTRACTION")
@Setter
@Getter
@Entity
@Builder
@ToString
@Immutable
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Attraction extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ATTRACTION")
    @SequenceGenerator(name = "SEQ_ATTRACTION", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PLA_SITE_ID")
    private PlaySite playSite;

    @Column(name = "SERIAL_NUMBER")
    @NotBlank
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private AttractionType type;

}
