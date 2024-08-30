package bit.schedule_new.service;

import bit.schedule_new.dto.NewScheduleResponse;
import bit.schedule_new.repository.NewScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewScheduleServiceImpl implements NewScheduleService {

    private final NewScheduleRepository newScheduleRepository;

    @Override
    public NewScheduleResponse getSchedule(Long scheduleId) {
        var schedule = newScheduleRepository
                .findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("스케줄을 찾지 못했습니다."));
        return new NewScheduleResponse(schedule);
    }

    @Override
    public List<NewScheduleResponse> getScheduleByUserId(Long userId) {
        return newScheduleRepository.findByUserId(userId)
                .stream()
                .map(NewScheduleResponse::new)
                .toList();
    }
}
