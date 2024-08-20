package bit.anniversary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bit.anniversary.entity.Anniversary;

@Repository
public interface AnRepository extends JpaRepository<Anniversary,Long> {
}
