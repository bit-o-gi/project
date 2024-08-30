package bit.schedule_new.service;

import bit.schedule_new.dto.NewScheduleResponse;

import java.util.List;

public interface NewScheduleService {
    NewScheduleResponse getSchedule(Long scheduleId);

    List<NewScheduleResponse> getScheduleByUserId(Long userId);
}
