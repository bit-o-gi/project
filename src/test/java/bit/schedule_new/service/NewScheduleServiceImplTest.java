package bit.schedule_new.service;

import bit.schedule_new.domain.NewSchedule;
import bit.schedule_new.dto.NewScheduleRequest;
import bit.schedule_new.dto.NewScheduleResponse;
import bit.schedule_new.repository.NewScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static bit.schedule_new.util.NewScheduleFixture.getNewSchedule;
import static bit.schedule_new.util.NewScheduleRequestFixture.getNewScheduleRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NewScheduleServiceImplTest {

    @Mock
    private NewScheduleRepository newScheduleRepository;

    @InjectMocks
    private NewScheduleServiceImpl scheduleService;

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
        NewSchedule newSchedule = getNewSchedule(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        when(newScheduleRepository.findById(1L)).thenReturn(Optional.ofNullable(newSchedule));
        //When
        NewScheduleResponse result = scheduleService.getSchedule(1L);
        //Then
        assertThat(result).isEqualTo(new NewScheduleResponse(newSchedule));
    }

    @DisplayName("저장시 스케줄의 시작시간이 종료시간보다 늦으면 에러를 발생시킨다.")
    @Test
    void saveValidateStartEndTime() {
        //Given
        NewScheduleRequest newScheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().minusHours(1));
        //When
        //Then
        assertThatThrownBy(() -> scheduleService.saveSchedule(newScheduleRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작 시간은 종료 시간보다 늦을 수 없습니다.");
    }

    @DisplayName("업데이트시 스케줄의 시작시간이 종료시간보다 늦으면 에러를 발생시킨다.")
    @Test
    void updateValidateStartEndTime() {
        //Given
        NewScheduleRequest newScheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().minusHours(1));
        when(newScheduleRepository.findById(0L)).thenReturn(Optional.ofNullable(getNewSchedule(LocalDateTime.now(), LocalDateTime.now().plusHours(1))));
        //When
        //Then
        assertThatThrownBy(() -> scheduleService.updateSchedule(0L, newScheduleRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시작 시간은 종료 시간보다 늦을 수 없습니다.");
    }

    @DisplayName("업데이트시 스케줄이 존재하지 않으면 에러를 발생시킨다.")
    @Test
    void updateScheduleScheduleNotFoundException() {
        //Given
        NewScheduleRequest newScheduleRequest = getNewScheduleRequest(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        //When
        //Then
        assertThatThrownBy(() -> scheduleService.updateSchedule(0L, newScheduleRequest))
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