package bit.schedule.domain;

import bit.schedule.domain.BaseEntity;
import bit.schedule.dto.ScheduleRequest;
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
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;

    private String content;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Builder
    public Schedule(Long userId, String title, String content, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        checkStartEndDateTime(startDateTime, endDateTime);
        this.userId = Objects.requireNonNull(userId);
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
        this.startDateTime = Objects.requireNonNull(startDateTime);
        this.endDateTime = Objects.requireNonNull(endDateTime);
    }

    public void update(ScheduleRequest scheduleRequest) {
        Objects.requireNonNull(scheduleRequest);
        checkStartEndDateTime(scheduleRequest.getStartDateTime(), scheduleRequest.getEndDateTime());
        this.userId = Objects.requireNonNull(scheduleRequest.getUserId());
        this.title = Objects.requireNonNull(scheduleRequest.getTitle());
        this.content = Objects.requireNonNull(scheduleRequest.getContent());
        this.startDateTime = Objects.requireNonNull(scheduleRequest.getStartDateTime());
        this.endDateTime = Objects.requireNonNull(scheduleRequest.getEndDateTime());
    }

    private void checkStartEndDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime.isAfter(endDateTime)) {
            throw new IllegalArgumentException("시작 시간은 종료 시간보다 늦을 수 없습니다.");
        }
    }
}
