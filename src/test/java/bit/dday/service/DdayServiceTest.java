package bit.dday.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

import bit.dday.domain.Dday;
import bit.dday.domain.DdayFixtures;
import bit.dday.dto.DdayRequest;
import bit.dday.dto.DdayRequestFixtures;
import bit.dday.repository.DdayRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DdayServiceTest {

    @Mock
    private DdayRepository ddayRepository;

    @InjectMocks
    private DdayService ddayService;

    @DisplayName("디데이 조회 성공")
    @Test
    void getDdaySuccessTest() throws Exception {
        // given
        Dday mockDday = DdayFixtures.initialDday();
        when(ddayRepository.findById(mockDday.getId())).thenReturn(Optional.of(mockDday));

        // when
        Dday dday = ddayService.getDday(mockDday.getId());

        // then
        assertThat(dday).usingRecursiveComparison().isEqualTo(mockDday);
    }

    @DisplayName("디데이 생성 성공")
    @Test
    void createDdaySuccessTest() throws Exception {
        //given
        Dday dday = DdayFixtures.initialDday();
        DdayRequest ddayRequest = DdayRequestFixtures.of();
        when(ddayRepository.save(any())).thenReturn(dday);

        // when
        Dday newDday = ddayService.createDday(ddayRequest.toCommand());

        // then
        assertThat(newDday).usingRecursiveComparison().isEqualTo(dday);
    }

    @DisplayName("디데이 수정 성공")
    @Test
    void updateDdaySuccessTest() throws Exception {
        // given
        Dday dday1 = DdayFixtures.initialDday();
        Dday dday2 = DdayFixtures.newDday();
        DdayRequest ddayRequest = DdayRequestFixtures.from(dday2);
        when(ddayRepository.findById(any())).thenReturn(Optional.of(dday1));
        when(ddayRepository.save(any())).thenReturn(dday2);

        // when
        Dday newDday = ddayService.updateDday(dday1.getId(), ddayRequest.toCommand());

        // then
        assertThat(newDday)
                .usingRecursiveComparison()
                .isEqualTo(dday2);
    }

    @DisplayName("디데이 삭제 성공")
    @Test
    void deleteDdaySuccessTest() throws Exception {
        // given
        when(ddayRepository.existsById(any())).thenReturn(true);
        // when
        ddayService.deleteDday(1L);

        // then
        then(ddayRepository).should().existsById(any());
        then(ddayRepository).should().deleteById(any());
    }
}
