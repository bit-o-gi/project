package bit.schedule.service;

import bit.schedule.domain.Schedule;
import bit.schedule.dto.ScheduleRequest;
import bit.schedule.dto.ScheduleResponse;
import bit.schedule.repository.ScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static bit.schedule.util.ScheduleFixture.getNewSchedule;
import static bit.schedule.util.ScheduleRequestFixture.getNewScheduleRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScheduleServiceImplTest {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    @DisplayName("스케줄 ID로 스케줄을 찾지 못한 경우 에러를 발생시킨다.")
    @Test
    void getScheduleTest() {
        //Given
        Long id = 1L;
        //When

        //Then
        assertThatThrownBy(() -> scheduleService.getSchedule(id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("스케줄을 찾지 못했습니다.");
    }

    @DisplayName("스케줄 저장 및 조회가 에러없이 되는지 확인한다.")
    @Test
    void saveNewScheduleTest() {
        //Given
        Schedule schedule = getNewSchedule(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        when(scheduleRepository.findById(1L)).thenReturn(Optional.ofNullable(schedule));
        //When
        ScheduleResponse result = scheduleService.getSchedule(1L);
        //Then
        assertThat(result).isEqualTo(new ScheduleResponse(Objects.requireNonNull(schedule)));
    }

    @DisplayName("저장시 스케줄의 시작시간이 종료시간보다 늦으면 에러를 발생시킨다.")
    @Test
    void saveValidateStartEndTime() {
        //Given
        ScheduleRequest scheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().minusHours(1));
        //When
        //Then
        assertThatThrownBy(() -> scheduleService.saveSchedule(scheduleRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작 시간은 종료 시간보다 늦을 수 없습니다.");
    }

    @DisplayName("업데이트시 스케줄의 시작시간이 종료시간보다 늦으면 에러를 발생시킨다.")
    @Test
    void updateValidateStartEndTime() {
        //Given
        ScheduleRequest scheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().minusHours(1));
        when(scheduleRepository.findById(0L)).thenReturn(Optional.ofNullable(getNewSchedule(LocalDateTime.now(), LocalDateTime.now().plusHours(1))));
        //When
        //Then
        assertThatThrownBy(() -> scheduleService.updateSchedule(0L, scheduleRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작 시간은 종료 시간보다 늦을 수 없습니다.");
    }

    @DisplayName("업데이트시 스케줄이 존재하지 않으면 에러를 발생시킨다.")
    @Test
    void updateScheduleScheduleNotFoundException() {
        //Given
        ScheduleRequest scheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        //When
        //Then
        assertThatThrownBy(() -> scheduleService.updateSchedule(0L, scheduleRequest))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("스케줄을 찾지 못했습니다.");
    }

    @DisplayName("삭제시 스케줄이 존재하지 않으면 에러를 발생시킨다.")
    @Test
    void deleteScheduleScheduleNotFoundException() {
        //Given
        //When
        //Then
        assertThatThrownBy(() -> scheduleService.deleteSchedule(0L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("스케줄을 찾지 못했습니다.");
    }
}