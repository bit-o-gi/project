package bit.dday.dto;

import bit.dday.domain.Dday;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class DdayRequestFixtures {
    public static DdayRequest of(String userId, String title, LocalDate targetDate) throws Exception {
        Class clazz = Class.forName("bit.dday.dto.DdayRequest");
        DdayRequest ddayRequest = new DdayRequest();

        Field userIdField = clazz.getDeclaredField("userId");
        userIdField.setAccessible(true);
        userIdField.set(ddayRequest, userId);

        Field titleField = clazz.getDeclaredField("title");
        titleField.setAccessible(true);
        titleField.set(ddayRequest, title);

        Field targetDateField = clazz.getDeclaredField("targetDate");
        targetDateField.setAccessible(true);
        targetDateField.set(ddayRequest, targetDate);

        return ddayRequest;
    }
}
