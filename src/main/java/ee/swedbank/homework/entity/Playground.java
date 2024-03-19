package ee.swedbank.homework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Immutable;

import java.util.HashSet;
import java.util.Set;

@Table(name = "PLAYGROUND")
@Setter
@Getter
@Entity
@Builder
@ToString
@Immutable
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Playground extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLAYGROUND")
    @SequenceGenerator(name = "SEQ_PLAYGROUND", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "playground")
    @Builder.Default
    private Set<PlaySite> playSites = new HashSet<>();

}
