package bit.schedule_new.controller;

import bit.schedule_new.dto.NewScheduleResponse;
import bit.schedule_new.service.NewScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedule")
public class NewScheduleController {
    private final NewScheduleService newScheduleService;

    @GetMapping("/{id}")
    public NewScheduleResponse getSchedule(@PathVariable Long scheduleId) {
        return newScheduleService.getSchedule(scheduleId);
    }

    @GetMapping("/user/{id}")
    public List<NewScheduleResponse> getScheduleByUser(@PathVariable Long userId) {
        return newScheduleService.getScheduleByUserId(userId);
    }
}
