package bit.couple.service;

import bit.couple.domain.Couple;
import bit.couple.dto.CoupleCommand;
import bit.couple.exception.CoupleException.CoupleNotFoundException;
import bit.couple.repository.CoupleRepository;
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

    public void approveCouple(Long coupleId) {
        Couple couple = coupleRepository.findById(coupleId).orElseThrow(CoupleNotFoundException::new);
        couple.approve();
        coupleRepository.save(couple);
    }

    public void deleteCouple(Long coupleId) {
        if (!coupleRepository.existsById(coupleId)) {
            throw new CoupleNotFoundException();
        }
        // TODO: 바로 지우는 대신 스케줄링 등록
        coupleRepository.deleteById(coupleId);
    }
}
