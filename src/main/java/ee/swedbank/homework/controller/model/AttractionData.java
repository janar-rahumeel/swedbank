package ee.swedbank.homework.controller.model;

import ee.swedbank.homework.entity.AttractionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AttractionData {

    private Long id;

    @NotNull
    private Long playSiteId;

    @NotBlank
    private String serialNumber;

    @NotNull
    private AttractionType type;

}
