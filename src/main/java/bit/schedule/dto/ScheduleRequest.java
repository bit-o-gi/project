package bit.schedule.dto;

import bit.schedule.domain.Schedule;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequest {

    @NotNull(message = "유저 아이디가 필요합니다.")
    private Long userId;

    @NotNull(message = "제목이 필요합니다.")
    private String title;

    @NotNull(message = "내용이 필요합니다.")
    private String content;

    @NotNull(message = "시작 일시가 필요합니다.")
    private LocalDateTime startDateTime;

    @NotNull(message = "종료 일시가 필요합니다.")
    private LocalDateTime endDateTime;

    @Builder
    public ScheduleRequest(Long userId, String title, String content, LocalDateTime startDateTime, LocalDateTime endDateTime) {
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
