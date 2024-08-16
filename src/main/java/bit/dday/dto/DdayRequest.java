package bit.dday.dto;

import bit.dday.domain.Dday;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class DdayRequest implements BaseRequest<Dday> {

    private Long id;

    private String userId;

    private String title;

    private LocalDate targetDate;

    @Override
    public Dday toEntity() {
        return Dday.builder()
                .id(id)
                .userId(userId)
                .title(title)
                .targetDate(targetDate)
                .build();
    }
}
