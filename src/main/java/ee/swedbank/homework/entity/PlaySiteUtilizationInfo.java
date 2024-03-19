package ee.swedbank.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlaySiteUtilizationInfo {

    private Short maximumKidVisitingCount;

    private Long currentKidVisitingCount;

}
