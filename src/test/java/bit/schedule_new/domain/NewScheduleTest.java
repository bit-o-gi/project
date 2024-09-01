package bit.schedule_new.domain;

import bit.schedule_new.dto.NewScheduleRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static bit.schedule_new.util.NewScheduleRequestFixture.getNewScheduleRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NewScheduleTest {

    @DisplayName("스케줄 객체를 수정 한다.")
    @Test
    void updateTest() {
        //Given
        NewScheduleRequest newScheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        NewSchedule newSchedule = newScheduleRequest.toEntity();
        NewScheduleRequest updateNewScheduleRequest = NewScheduleRequest.builder()
                .userId(2L)
                .title("title update test")
                .content("content update test")
                .startDateTime(LocalDateTime.of(2024, 9, 1, 1, 1))
                .endDateTime(LocalDateTime.of(2024, 9, 1, 1, 1))
                .build();
        //When
        newSchedule.update(updateNewScheduleRequest);
        //Then
        assertThat(newSchedule).extracting(
                "userId",
                "title",
                "content",
                "startDateTime",
                "endDateTime"
        ).containsExactly(
                2L,
                "title update test",
                "content update test",
                LocalDateTime.of(2024, 9, 1, 1, 1),
                LocalDateTime.of(2024, 9, 1, 1, 1)
        );
    }

    @DisplayName("스케줄 객체를 수정 시 시작 시간이 종료 시간보다 늦으면 에러를 발생시킨다.")
    @Test
    void updateValidStartEndTimeTest() {
        //Given
        NewScheduleRequest newScheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        NewSchedule newSchedule = newScheduleRequest.toEntity();
        NewScheduleRequest updateNewScheduleRequest = NewScheduleRequest.builder()
                .userId(2L)
                .title("title update test")
                .content("content update test")
                .startDateTime(LocalDateTime.of(2024, 9, 1, 1, 1))
                .endDateTime(LocalDateTime.of(2024, 8, 1, 1, 1))
                .build();
        //When
        //Then
        assertThatThrownBy(() -> newSchedule.update(updateNewScheduleRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작 시간은 종료 시간보다 늦을 수 없습니다.");
    }

}