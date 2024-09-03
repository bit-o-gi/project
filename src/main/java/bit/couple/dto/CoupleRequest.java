package bit.couple.dto;

import bit.couple.domain.Couple;
import bit.couple.domain.CoupleStatus;
import bit.dday.dto.BaseCommand;
import bit.dday.dto.BaseRequest;
import bit.user.entity.UserEntity;
import java.util.List;
import lombok.Getter;

@Getter
public class CoupleRequest implements BaseRequest<Couple> {
    private List<UserEntity> users;

    @Override
    public CoupleCommand toCommand() {
        return new CoupleCommand();
    }
}
