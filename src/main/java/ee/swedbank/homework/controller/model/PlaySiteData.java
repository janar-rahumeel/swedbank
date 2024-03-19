package ee.swedbank.homework.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaySiteData {

    private Long id;

    @NotNull
    private Long playgroundId;

    @NotBlank
    private String name;

    @NotNull
    private Short maximumKidCapacity;

    private Set<Long> attractionIds;

}
