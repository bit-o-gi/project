package bit.schedule_new.service;

import bit.schedule_new.domain.NewSchedule;
import bit.schedule_new.dto.NewScheduleRequest;
import bit.schedule_new.dto.NewScheduleResponse;
import bit.schedule_new.repository.NewScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NewScheduleServiceImpl implements NewScheduleService {

    private final NewScheduleRepository newScheduleRepository;

    @Override
    public NewScheduleResponse getSchedule(Long scheduleId) {
        NewSchedule schedule = findScheduleById(scheduleId);
        return new NewScheduleResponse(schedule);
    }

    @Override
    public List<NewScheduleResponse> getSchedulesByUserId(Long userId) {
        return newScheduleRepository.findByUserId(userId)
                .stream()
                .map(NewScheduleResponse::new)
                .toList();
    }

    @Transactional
    @Override
    public NewScheduleResponse saveSchedule(NewScheduleRequest newScheduleRequest) {
        NewSchedule schedule = newScheduleRequest.toEntity();
        newScheduleRepository.save(schedule);
        return new NewScheduleResponse(schedule);
    }

    @Transactional
    @Override
    public NewScheduleResponse updateSchedule(Long scheduleId, NewScheduleRequest newScheduleRequest) {
        NewSchedule schedule = findScheduleById(scheduleId);
        schedule.update(newScheduleRequest);
        newScheduleRepository.save(schedule);
        return new NewScheduleResponse(schedule);
    }

    @Transactional
    @Override
    public NewScheduleResponse deleteSchedule(Long scheduleId) {
        NewSchedule schedule = findScheduleById(scheduleId);
        newScheduleRepository.deleteById(scheduleId);
        return new NewScheduleResponse(schedule);
    }

    private NewSchedule findScheduleById(Long scheduleId) {
        return newScheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new EntityNotFoundException("스케줄을 찾지 못했습니다."));
    }
}
