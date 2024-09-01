package bit.schedule_new.controller;

import bit.schedule_new.dto.NewScheduleRequest;
import bit.schedule_new.dto.NewScheduleResponse;
import bit.schedule_new.service.NewScheduleService;
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
        return newScheduleService.getScheduleByUserId(userId);
    }

    @PostMapping("")
    public NewScheduleResponse createSchedule(@RequestBody NewScheduleRequest newScheduleRequest) {
        return newScheduleService.saveSchedule(newScheduleRequest);
    }

    @PatchMapping("/{scheduleId}")
    public NewScheduleResponse updateSchedule(@PathVariable Long scheduleId, @RequestBody NewScheduleRequest newScheduleRequest) {
        return newScheduleService.updateSchedule(scheduleId, newScheduleRequest);
    }
}
