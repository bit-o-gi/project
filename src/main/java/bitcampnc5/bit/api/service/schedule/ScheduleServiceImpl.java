package bitcampnc5.bit.api.service.schedule;

import bitcampnc5.bit.api.dto.schedule.ScheduleRequest;
import bitcampnc5.bit.api.repository.schedule.ScheduleRepository;
import bitcampnc5.bit.domain.schedule.Schedule;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public void save(ScheduleRequest scheduleRequest) {
        LocalDateTime startDateTime = scheduleRequest.getStartDateTime();
        LocalDateTime endDateTime = scheduleRequest.getEndDateTime();

        if (startDateTime.isAfter(endDateTime)) {
            throw new IllegalArgumentException("시작 시간이 종료 시간보다 늦을 수 없습니다.");
        }

        scheduleRepository.save(scheduleRequest.toEntity());
    }
}
