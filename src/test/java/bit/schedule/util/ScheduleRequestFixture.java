package bit.schedule.util;

import bit.schedule.dto.ScheduleRequest;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleRequestFixture {
    public static ScheduleRequest getNewScheduleRequest(LocalDateTime start, LocalDateTime end) {
        return ScheduleRequest.builder()
                .userId(1L)
                .title("title")
                .content("content")
                .startDateTime(start)
                .endDateTime(end)
                .build();
    }

    public static List<ScheduleRequest> getNewScheduleRequests() {
        return List.of(
                ScheduleRequest.builder()
                        .title("title")
                        .content("content")
                        .startDateTime(LocalDateTime.now())
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                ScheduleRequest.builder()
                        .userId(1L)
                        .content("content")
                        .startDateTime(LocalDateTime.now())
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                ScheduleRequest.builder()
                        .userId(1L)
                        .title("title")
                        .startDateTime(LocalDateTime.now())
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                ScheduleRequest.builder()
                        .userId(1L)
                        .title("title")
                        .content("content")
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                ScheduleRequest.builder()
                        .userId(1L)
                        .title("title")
                        .content("content")
                        .startDateTime(LocalDateTime.now())
                        .build()
        );
    }
}
