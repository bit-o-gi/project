package bit.dday.domain;

import bit.couple.domain.Couple;
import bit.dday.dto.DdayCommand;
import bit.schedule.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    @OneToOne(optional = false)
    private Couple couple;
    private String title;
    private LocalDate targetDate;

    @Builder
    private Dday(Couple couple, String title, LocalDate targetDate) {
        this.couple = couple;
        this.title = title;
        this.targetDate = targetDate;
    }

    public void update(DdayCommand ddayCommand) {
        this.title = ddayCommand.title;
        this.targetDate = ddayCommand.targetDate;
    }
}
