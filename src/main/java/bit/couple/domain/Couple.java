package bit.couple.domain;

import bit.dday.domain.Dday;
import bit.schedule.domain.BaseEntity;
import bit.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Couple extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // UserEntity 쪽에서도 mapping 필요!
    @Transient
    @OneToMany(mappedBy = "couple")
    private List<UserEntity> users;

    // Dday 쪽에서도 mapping 필요!
    @Transient
    @OneToOne(mappedBy = "couple")
    private Dday dday;

    private CoupleStatus status;

    public static Couple of(List<UserEntity> users) {
        Couple couple = new Couple();
        couple.users = users;
        couple.status = CoupleStatus.CREATING;
        return couple;
    }

    public void approve() {
        this.status = CoupleStatus.APPROVED;
    }
}
