//package bit.dday.domain;
//
//import java.lang.reflect.Field;
//import java.time.LocalDate;
//
//public class DdayFixtures {
//    public static Dday initialDday() throws Exception {
//        return of(1L, "testId", "초기 제목", LocalDate.of(2024, 8, 15));
//    }
//
//    public static Dday newDday() throws Exception {
//        return of(1L, "testId", "생성된 디데이 제목", LocalDate.of(2024, 9, 16));
//    }
//
//    public static Dday updatedDday() throws Exception {
//        return of(1L, "testId", "수정된 디데이 제목", LocalDate.of(2024, 10, 17));
//    }
//
//    public static Dday of(Long id, String userId, String title, LocalDate targetDate) throws Exception {
//        Dday dday = Dday.builder()
//                .couple()
//                .title(title)
//                .targetDate(targetDate)
//                .build();
//
//        Class<?> clazz = Class.forName("bit.dday.domain.Dday");
//        Field idField = clazz.getDeclaredField("id");
//        idField.setAccessible(true);
//        idField.set(dday, id);
//
//        return dday;
//    }
//}
