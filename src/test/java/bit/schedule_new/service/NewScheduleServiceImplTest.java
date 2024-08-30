package bit.schedule_new.service;

import bit.schedule_new.repository.NewScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

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

}