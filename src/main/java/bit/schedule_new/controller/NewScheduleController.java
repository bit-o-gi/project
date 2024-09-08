package bit.schedule_new.controller;

import bit.schedule_new.dto.NewScheduleRequest;
import bit.schedule_new.dto.NewScheduleResponse;
import bit.schedule_new.service.NewScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedule")
public class NewScheduleController {
    private final NewScheduleService newScheduleService;

    @GetMapping("/{scheduleId}")
    public NewScheduleResponse getSchedule(@PathVariable Long scheduleId) {
        return newScheduleService.getSchedule(scheduleId);
    }

    @GetMapping("/user/{userId}")
    public List<NewScheduleResponse> getScheduleByUser(@PathVariable Long userId) {
        return newScheduleService.getSchedulesByUserId(userId);
    }

    @PostMapping("")
    public NewScheduleResponse createSchedule(@Valid @RequestBody NewScheduleRequest newScheduleRequest) {
        return newScheduleService.saveSchedule(newScheduleRequest);
    }

    @PutMapping("/{scheduleId}")
    public NewScheduleResponse updateSchedule(@PathVariable Long scheduleId, @Valid @RequestBody NewScheduleRequest newScheduleRequest) {
        return newScheduleService.updateSchedule(scheduleId, newScheduleRequest);
    }

    @DeleteMapping("/{scheduleId}")
    public NewScheduleResponse deleteSchedule(@PathVariable Long scheduleId) {
        return newScheduleService.deleteSchedule(scheduleId);
    }
}
