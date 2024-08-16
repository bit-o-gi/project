package bit.dday.dto;

import bit.dday.domain.Dday;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class DdayRequest implements BaseRequest<Dday> {

    @NotNull(message = "유저 아이디는 필수입니다.")
    private String userId;

    @NotNull(message = "제목은 필수입니다.")
    private String title;

    @NotNull(message = "대상 날짜는 필수입니다.")
    private LocalDate targetDate;

    @Override
    public Dday toEntity() {
        return Dday.builder()
                .userId(userId)
                .title(title)
                .targetDate(targetDate)
                .build();
    }
}
