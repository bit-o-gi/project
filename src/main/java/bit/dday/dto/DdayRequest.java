package bit.dday.dto;

import bit.dday.domain.Dday;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class DdayRequest implements BaseRequest<Dday> {
    private Long userId;
    private String title;
    private LocalDate targetDate;

    @Override
    public DdayCommand toCommand() {
        return new DdayCommand(userId, title, targetDate);
    }
}
