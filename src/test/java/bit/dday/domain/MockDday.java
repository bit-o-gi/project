package bit.dday.domain;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class MockDday {
    public static Dday mock1() throws Exception {
        return of(1L, "testId", "디데이 제목", LocalDate.of(2024, 8, 15));
    }

    public static Dday mock2() throws Exception {
        return of(1L, "testId", "새로운 디데이 제목", LocalDate.of(2024, 9, 16));
    }

    public static Dday of(Long id, String userId, String title, LocalDate targetDate) throws Exception {
        Dday dday = Dday.builder()
                .userId(userId)
                .title(title)
                .targetDate(targetDate)
                .build();

        Class clazz = Class.forName("bit.dday.domain.Dday");
        Field idField = clazz.getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(dday, id);

        return dday;
    }
}
