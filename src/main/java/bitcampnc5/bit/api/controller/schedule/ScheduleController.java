package bitcampnc5.bit.api.controller.schedule;

import bitcampnc5.bit.api.dto.schedule.ScheduleRequest;
import bitcampnc5.bit.api.service.schedule.ScheduleService;
import bitcampnc5.bit.domain.schedule.Schedule;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;


    @PostMapping("/api/v1/schedules/new")
    public ResponseEntity<Schedule> createSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest) {
        Schedule createdSchedule = scheduleService.save(scheduleRequest);

        return ResponseEntity.ok(createdSchedule);
    }

}
