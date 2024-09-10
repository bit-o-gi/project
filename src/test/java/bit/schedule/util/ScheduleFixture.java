package bit.schedule.util;

import bit.schedule.domain.Schedule;

import java.time.LocalDateTime;

public class ScheduleFixture {

    public static Schedule getNewSchedule(LocalDateTime start, LocalDateTime end) {
        return Schedule.builder()
                .userId(1L)
                .title("title")
                .content("content")
                .startDateTime(start)
                .endDateTime(end)
                .build();
    }
}
