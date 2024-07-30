package bit.schedule.service;

import bit.schedule.dto.ScheduleRequest;
import bit.schedule.domain.Schedule;

public interface ScheduleService {
    Schedule getSchedule(Long id);

    Schedule save(ScheduleRequest scheduleRequest);

    Schedule patch(Long id, ScheduleRequest scheduleRequest);

    Schedule delete(Long id);
}
