package bit.couple.dto;

import bit.couple.domain.Couple;
import bit.couple.domain.CoupleStatus;
import bit.dday.dto.BaseCommand;
import bit.user.entity.UserEntity;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CoupleCommand implements BaseCommand<Couple> {
    private List<UserEntity> users;
}
