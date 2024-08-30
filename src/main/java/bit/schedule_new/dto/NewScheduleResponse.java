package bit.schedule_new.dto;

import bit.schedule_new.domain.NewSchedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NewScheduleResponse {

    private String title;

    private String content;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public NewScheduleResponse(NewSchedule schedule) {
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.startDateTime = schedule.getStartDateTime();
        this.endDateTime = schedule.getEndDateTime();
    }
}
