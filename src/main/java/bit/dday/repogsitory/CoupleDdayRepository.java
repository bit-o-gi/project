package bit.dday.repogsitory;

import bit.dday.entity.CoupleDday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleDdayRepository extends JpaRepository<CoupleDday, Long> {
}
