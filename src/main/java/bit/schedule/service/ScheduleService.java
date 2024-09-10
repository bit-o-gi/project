package bit.schedule.service;

import bit.schedule.dto.ScheduleRequest;
import bit.schedule.dto.ScheduleResponse;

import java.util.List;

public interface ScheduleService {
    ScheduleResponse getSchedule(Long scheduleId);

    List<ScheduleResponse> getSchedulesByUserId(Long userId);

    ScheduleResponse saveSchedule(ScheduleRequest scheduleRequest);

    ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest scheduleRequest);

    ScheduleResponse deleteSchedule(Long scheduleId);
}
