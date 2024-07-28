package bit.api.dto.schedule;

import bit.domain.schedule.Schedule;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleRequest {

    @NotNull(message = "유저 아이디는 필수입니다.")
    private String userId;

    @NotNull(message = "제목은 필수입니다.")
    private String title;

    private String content;

    @NotNull(message = "시작 일시는 필수입니다.")
    private LocalDateTime startDateTime;

    @NotNull(message = "종료 일시는 필수입니다.")
    private LocalDateTime endDateTime;

    @Builder
    public ScheduleRequest(String userId, String title, String content, LocalDateTime startDateTime,
                           LocalDateTime endDateTime) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public Schedule toEntity() {
        return Schedule.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .build();
    }

}
