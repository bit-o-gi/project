package bitcampnc5.bit.api.service.schedule;

import bitcampnc5.bit.api.dto.schedule.ScheduleRequest;
import bitcampnc5.bit.domain.schedule.Schedule;

public interface ScheduleService {
    Schedule getSchedule(Long id);

    Schedule save(ScheduleRequest scheduleRequest);

    Schedule patch(Long id, ScheduleRequest scheduleRequest);

    void delete(Long id);
}
