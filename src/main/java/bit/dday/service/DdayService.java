package bit.dday.service;

import bit.dday.domain.Dday;
import bit.dday.dto.DdayRequest;
import bit.dday.exception.DdayException.DdayNotFoundException;
import bit.dday.repository.DdayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DdayService {

    private final DdayRepository ddayRepository;

    public Dday getDday(Long id) {
        return ddayRepository.findById(id).orElseThrow(DdayNotFoundException::new);
    }

    public Dday createDday(DdayRequest ddayRequest) {
        Dday ddayInput = ddayRequest.toEntity();
        return ddayRepository.save(ddayInput);
    }

    public Dday updateDday(Long id, DdayRequest ddayRequest) {
        Dday dday = ddayRepository.findById(id).orElseThrow(DdayNotFoundException::new);
        dday.update(ddayRequest);
        return ddayRepository.save(dday);
    }

    public void deleteDday(Long id) {
        if (!ddayRepository.existsById(id)) {
            throw new DdayNotFoundException();
        }
        ddayRepository.deleteById(id);
    }
}
