package bitcampnc5.bit.domain.schedule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bitcampnc5.bit.api.dto.schedule.ScheduleRequest;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScheduleTest {

    @DisplayName("schedule 객체를 수정 한다.")
    @Test
    void updateTest() {
        // given
        ScheduleRequest scheduleRequest = ScheduleRequest.builder()
                .userId("testId")
                .title("일정 제목")
                .content("일정 내용")
                .startDateTime(LocalDateTime.of(2021, 10, 10, 10, 10))
                .endDateTime(LocalDateTime.of(2021, 10, 10, 10, 10))
                .build();

        Schedule schedule = scheduleRequest.toEntity();

        ScheduleRequest updatedScheduleRequest = ScheduleRequest.builder()
                .userId("testId")
                .title("수정된 일정 제목")
                .content("수정된 일정 내용")
                .startDateTime(LocalDateTime.of(2022, 10, 10, 10, 10))
                .endDateTime(LocalDateTime.of(2022, 10, 10, 10, 10))
                .build();

        // when
        schedule.update(updatedScheduleRequest);

        // then
        assertThat(schedule).extracting(
                "userId",
                "title",
                "content",
                "startDateTime",
                "endDateTime"
        ).containsExactly(
                "testId",
                "수정된 일정 제목",
                "수정된 일정 내용",
                LocalDateTime.of(2022, 10, 10, 10, 10),
                LocalDateTime.of(2022, 10, 10, 10, 10)
        );
    }

}