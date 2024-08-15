package bit.dday.service;

import bit.dday.dto.CoupleDdayDto;
import bit.dday.entity.CoupleDday;
import bit.dday.repogsitory.CoupleDdayRepository;
import bit.dday.service.impl.CoupleDdayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class CoupleDdayServiceImplTest {

    @InjectMocks
    private CoupleDdayServiceImpl coupleDdayService;

    @Mock
    private CoupleDdayRepository coupleDdayRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterDday() {
        // Given
        CoupleDdayDto dto = new CoupleDdayDto();
        dto.setPartner1("마리오");
        dto.setPartner2("버섯");
        dto.setDdayDate(LocalDate.of(2024, 8, 15));

        CoupleDday coupleDday = new CoupleDday();
        coupleDday.setId(1L);
        coupleDday.setPartner1("마리오");
        coupleDday.setPartner2("버섯");
        coupleDday.setDdayDate(LocalDate.of(2024, 8, 15));

        when(coupleDdayRepository.save(any(CoupleDday.class))).thenReturn(coupleDday);

        // When
        CoupleDdayDto result = coupleDdayService.registerDday(dto);

        // Then
        assertEquals(dto.getPartner1(), result.getPartner1());
        assertEquals(dto.getPartner2(), result.getPartner2());
        assertEquals(dto.getDdayDate(), result.getDdayDate());
    }
}
