package bit.dday.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import bit.dday.domain.Dday;
import bit.dday.domain.MockDday;
import bit.dday.dto.DdayRequest;
import bit.dday.dto.MockDdayRequest;
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
        Dday mockDday = MockDday.mock1();
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
        Dday dday = MockDday.mock1();
        DdayRequest ddayRequest = MockDdayRequest.mockWith(dday);
        when(ddayRepository.save(any())).thenReturn(dday);

        // when
        Dday newDday = ddayService.createDday(ddayRequest);

        // then
        assertThat(newDday).usingRecursiveComparison().isEqualTo(dday);
    }

    @DisplayName("디데이 수정 성공")
    @Test
    void updateDdaySuccessTest() throws Exception {
        // given
        Dday dday1 = MockDday.mock1();
        Dday dday2 = MockDday.mock2();
        DdayRequest ddayRequest = MockDdayRequest.mockWith(dday2);
        when(ddayRepository.findById(any())).thenReturn(Optional.of(dday1));
        when(ddayRepository.save(any())).thenReturn(dday2);

        // when
        Dday newDday = ddayService.updateDday(dday1.getId(), ddayRequest);

        // then
        assertThat(newDday)
                .usingRecursiveComparison()
                .isEqualTo(dday2);
    }
}
