package bitcampnc5.bit.api.service.schedule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

import bitcampnc5.bit.api.dto.schedule.ScheduleRequest;
import bitcampnc5.bit.api.repository.schedule.ScheduleRepository;
import bitcampnc5.bit.domain.schedule.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class ScheduleServiceImplTest {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    @DisplayName("유효한 일정을 기입 했을 때, 일정이 잘 저장되는지 확인한다.")
    @Test
    void saveTest() {
        // given
        LocalDateTime now = LocalDateTime.now();
        ScheduleRequest scheduleRequestDto = createScheduleRequest("testId", "일정 제목", "일정 내용", now, now);

        // when
        scheduleService.save(scheduleRequestDto);

        // then
        then(scheduleRepository).should().save(ArgumentMatchers.any(Schedule.class));
    }

    @DisplayName("시작 시간이 종료 시간보다 뒤일 경우 예외가 발생한다")
    @Test
    void saveValidateTest() {
        // given
        LocalDateTime startDateTime = LocalDateTime.now().plusSeconds(1);
        LocalDateTime endDateTime = LocalDateTime.now();
        ScheduleRequest scheduleRequestDto = createScheduleRequest("testId", "일정 제목", "일정 내용", startDateTime,
                endDateTime);
        // when // then
        assertThatThrownBy(() -> scheduleService.save(scheduleRequestDto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작 시간이 종료 시간보다 늦을 수 없습니다.");
    }

    private ScheduleRequest createScheduleRequest(String userId, String title, String content,
                                                  LocalDateTime startDateTime,
                                                  LocalDateTime endDateTime) {
        return ScheduleRequest.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .build();
    }
}