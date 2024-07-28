package bit.api.service.schedule;

import bit.api.dto.schedule.ScheduleRequest;
import bit.domain.schedule.Schedule;

public interface ScheduleService {
    Schedule getSchedule(Long id);

    Schedule save(ScheduleRequest scheduleRequest);

    Schedule patch(Long id, ScheduleRequest scheduleRequest);

    Schedule delete(Long id);
}
