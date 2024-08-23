package bit.dday.dto;

import bit.dday.domain.Dday;
import java.time.LocalDate;

public class DdayCommand implements BaseCommand<Dday> {
    public final String userId;
    public final String title;
    public final LocalDate targetDate;

    public DdayCommand(String userId, String title, LocalDate targetDate) {
        this.userId = userId;
        this.title = title;
        this.targetDate = targetDate;
    }
}
