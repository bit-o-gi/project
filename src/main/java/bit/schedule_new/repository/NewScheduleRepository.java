package bit.schedule_new.repository;

import bit.schedule_new.domain.NewSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewScheduleRepository extends JpaRepository<NewSchedule, Long> {
    List<NewSchedule> findByUserId(Long userId);
}
