package bit.schedule_new.domain;

import bit.schedule.domain.BaseEntity;
import bit.schedule_new.dto.NewScheduleRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
public class NewSchedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;

    private String content;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Builder
    public NewSchedule(Long userId, String title, String content, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        checkStartEndDateTime(startDateTime, endDateTime);
        this.userId = Objects.requireNonNull(userId);
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
        this.startDateTime = Objects.requireNonNull(startDateTime);
        this.endDateTime = Objects.requireNonNull(endDateTime);
    }

    public void update(NewScheduleRequest newScheduleRequest) {
        Objects.requireNonNull(newScheduleRequest);
        checkStartEndDateTime(newScheduleRequest.getStartDateTime(), newScheduleRequest.getEndDateTime());
        this.userId = Objects.requireNonNull(newScheduleRequest.getUserId());
        this.title = Objects.requireNonNull(newScheduleRequest.getTitle());
        this.content = Objects.requireNonNull(newScheduleRequest.getContent());
        this.startDateTime = Objects.requireNonNull(newScheduleRequest.getStartDateTime());
        this.endDateTime = Objects.requireNonNull(newScheduleRequest.getEndDateTime());
    }

    private void checkStartEndDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime.isAfter(endDateTime)) {
            throw new IllegalArgumentException("시작 시간은 종료 시간보다 늦을 수 없습니다.");
        }
    }
}
