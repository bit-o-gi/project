package bit.dday.dto;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class MockDdayRequest {

    public static DdayRequest of() throws Exception {
        Class clazz = Class.forName("bit.dday.dto.DdayRequest");
        DdayRequest ddayRequest = new DdayRequest();

        Field id = clazz.getDeclaredField("id");
        id.setAccessible(true);
        id.set(ddayRequest, 1L);

        Field userId = clazz.getDeclaredField("userId");
        userId.setAccessible(true);
        userId.set(ddayRequest, "testId");

        Field title = clazz.getDeclaredField("title");
        title.setAccessible(true);
        title.set(ddayRequest, "디데이 제목");
        Field targetDate = clazz.getDeclaredField("targetDate");
        targetDate.setAccessible(true);
        targetDate.set(ddayRequest, LocalDate.of(2024, 8, 15));

        return ddayRequest;
    }
}
