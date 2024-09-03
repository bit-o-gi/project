package bit.dday.dto;

import bit.couple.domain.Couple;
import bit.dday.domain.Dday;
import java.time.LocalDate;

public class DdayCommand implements BaseCommand<Dday> {
    public final Long userId;
    public final String title;
    public final LocalDate targetDate;

    public DdayCommand(Long userId, String title, LocalDate targetDate) {
        this.userId = userId;
        this.title = title;
        this.targetDate = targetDate;
    }
}
