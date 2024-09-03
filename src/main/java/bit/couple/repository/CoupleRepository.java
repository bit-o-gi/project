package bit.couple.repository;

import bit.couple.domain.Couple;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long> {
    Optional<Couple> findByUsersId(Long id);
}
