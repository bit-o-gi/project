package bit.schedule_new.util;

import bit.schedule_new.dto.NewScheduleRequest;

import java.time.LocalDateTime;
import java.util.List;

public class NewScheduleRequestFixture {
    public static NewScheduleRequest getNewScheduleRequest(LocalDateTime start, LocalDateTime end) {
        return NewScheduleRequest.builder()
                .userId(1L)
                .title("title")
                .content("content")
                .startDateTime(start)
                .endDateTime(end)
                .build();
    }

    public static List<NewScheduleRequest> getNewScheduleRequests() {
        return List.of(
                NewScheduleRequest.builder()
                        .title("title")
                        .content("content")
                        .startDateTime(LocalDateTime.now())
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                NewScheduleRequest.builder()
                        .userId(1L)
                        .content("content")
                        .startDateTime(LocalDateTime.now())
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                NewScheduleRequest.builder()
                        .userId(1L)
                        .title("title")
                        .startDateTime(LocalDateTime.now())
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                NewScheduleRequest.builder()
                        .userId(1L)
                        .title("title")
                        .content("content")
                        .endDateTime(LocalDateTime.now().plusHours(1))
                        .build(),
                NewScheduleRequest.builder()
                        .userId(1L)
                        .title("title")
                        .content("content")
                        .startDateTime(LocalDateTime.now())
                        .build()
        );
    }
}
