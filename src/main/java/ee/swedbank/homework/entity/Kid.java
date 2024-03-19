package ee.swedbank.homework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Table(name = "KID")
@Setter
@Getter
@Entity
@Builder
@ToString
@Immutable
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Kid extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_KID")
    @SequenceGenerator(name = "SEQ_KID", initialValue = 1000, allocationSize = 1)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Short age;

    @Column(name = "TICKET_NUMBER")
    @NotBlank
    private String ticketNumber;

}
