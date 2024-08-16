package bit.dday.dto;

import bit.dday.domain.Dday;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DdayResponse {
    private Long id;

    private String userId;

    private String title;

    private LocalDate targetDate;

    public static DdayResponse from(Dday dday) {
        return DdayResponse.builder()
                .id(dday.getId())
                .userId(dday.getUserId())
                .title(dday.getTitle())
                .targetDate(dday.getTargetDate())
                .build();
    }
}
