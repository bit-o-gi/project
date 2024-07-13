package bitcampnc5.bit.api.repository.schedule;

import bitcampnc5.bit.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
