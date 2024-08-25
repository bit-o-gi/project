package bit.dday.domain;

import bit.dday.dto.DdayCommand;
import bit.schedule.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Dday extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    /* TODO
        userId는 이후 couple 객체로 대체
        private Couple couple;
    */
    private String title;
    private LocalDate targetDate;

    @Builder
    private Dday(String userId, String title, LocalDate targetDate) {
        this.userId = userId;
        this.title = title;
        this.targetDate = targetDate;
    }

    public void update(DdayCommand ddayCommand) {
        this.userId = ddayCommand.userId;
        this.title = ddayCommand.title;
        this.targetDate = ddayCommand.targetDate;
    }
}
