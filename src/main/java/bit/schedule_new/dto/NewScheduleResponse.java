package bit.schedule_new.dto;

import bit.schedule_new.domain.NewSchedule;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
public class NewScheduleResponse {
    private Long id;

    private Long userId;

    private String title;

    private String content;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public NewScheduleResponse(NewSchedule schedule) {
        this.id = schedule.getId();
        this.userId = schedule.getUserId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.startDateTime = schedule.getStartDateTime();
        this.endDateTime = schedule.getEndDateTime();
    }
}
