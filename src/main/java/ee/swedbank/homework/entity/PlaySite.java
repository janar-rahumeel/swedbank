package ee.swedbank.homework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Immutable;

import java.util.HashSet;
import java.util.Set;

@Table(name = "PLAY_SITE")
@Setter
@Getter
@Entity
@Builder
@ToString
@Immutable
@NoArgsConstructor
@EqualsAndHashCode(of = "name", callSuper = false)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaySite extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLAY_SITE")
    @SequenceGenerator(name = "SEQ_PLAY_SITE", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PLAYGROUND_ID")
    private Playground playground;

    @NotBlank
    private String name;

    @NotNull
    private Short maximumKidCapacity;

    @NotEmpty
    @OneToMany(mappedBy = "playSite")
    @Builder.Default
    private Set<Attraction> attractions = new HashSet<>();

}
