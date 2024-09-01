package bit.schedule_new.util;

import bit.schedule_new.domain.NewSchedule;

import java.time.LocalDateTime;

public class NewScheduleFixture {

    public static NewSchedule getNewSchedule(LocalDateTime start, LocalDateTime end) {
        return NewSchedule.builder()
                .userId(1L)
                .title("title")
                .content("content")
                .startDateTime(start)
                .endDateTime(end)
                .build();
    }
}
