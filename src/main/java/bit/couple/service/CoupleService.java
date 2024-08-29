package bit.couple.service;

import bit.couple.domain.Couple;
import bit.couple.dto.CoupleCommand;
import bit.couple.repository.CoupleRepository;
import bit.user.entity.UserEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoupleService {

    private final CoupleRepository coupleRepository;

    public void createCouple(CoupleCommand command) {
        Couple couple = Couple.of(command.getUsers());
        coupleRepository.save(couple);
    }
}
