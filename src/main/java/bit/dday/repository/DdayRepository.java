package bit.dday.repository;

import bit.dday.domain.Dday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DdayRepository extends JpaRepository<Dday, Long> {
}
