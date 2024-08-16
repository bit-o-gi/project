package bit.dday.domain;

import bit.dday.dto.DdayRequest;
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

    private String title;

    private LocalDate targetDate;

    @Builder
    private Dday(String userId, String title, LocalDate targetDate) {
        this.userId = userId;
        this.title = title;
        this.targetDate = targetDate;
    }

    public void update(DdayRequest ddayRequest) {
        this.userId = ddayRequest.getUserId();
        this.title = ddayRequest.getTitle();
        this.targetDate = ddayRequest.getTargetDate();
    }
}
