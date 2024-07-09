package bitcampnc5.bit.domain.schedule;

import bitcampnc5.bit.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String title;

    private String content;
    
    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;


}
