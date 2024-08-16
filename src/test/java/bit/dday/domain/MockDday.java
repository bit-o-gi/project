package bit.dday.domain;

import java.time.LocalDate;

public class MockDday {
    public static Dday of() {
        return Dday.builder()
                .id(1L)
                .userId("testId")
                .title("디데이 제목")
                .targetDate(LocalDate.of(2024, 8, 15))
                .build();
    }
}
