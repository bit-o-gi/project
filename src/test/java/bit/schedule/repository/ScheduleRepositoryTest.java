package bit.schedule.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import bit.schedule.domain.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ScheduleRepositoryTest {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @DisplayName("일정을 기입 했을 때, 일정이 잘 저장되는지 확인한다.")
    @Test
    void saveTest() {
        // given
        LocalDateTime now = LocalDateTime.now();
        Schedule schedule = createSchedule("testId", "일정 제목", "일정 내용", now, now);
        scheduleRepository.save(schedule);

        // when
        List<Schedule> findSchedule = scheduleRepository.findAll();

        // then
        assertThat(findSchedule).hasSize(1)
                .extracting("Id", "userId", "title", "content", "startDateTime")
                .containsExactlyInAnyOrder(
                        tuple(1L, "testId", "일정 제목", "일정 내용", now)
                );
    }

    private Schedule createSchedule(String userId, String title, String content, LocalDateTime startDateTime,
                                    LocalDateTime endDateTime) {
        return Schedule.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .build();
    }

}