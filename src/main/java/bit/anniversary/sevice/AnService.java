package bit.anniversary.sevice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.anniversary.dto.AnDto;
import bit.anniversary.dto.AnResDto;
import bit.anniversary.repository.AnRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnService {

    private final AnRepository anRepository;


    public AnDto saveAnniverSary(AnDto andto) {
        return anRepository.save(andto.creatAnniversary()).creatAnniversary();
    }

    @Transactional
    public AnDto updateAnniverSary(AnDto anDto) {
        anRepository.findById(anDto.getId()).orElseThrow(EntityNotFoundException::new).update(anDto);
        return anDto;
    }

    // TODO: 추후 flyway 도입으로 crud에서 r 빼고 flyway에 책임을 넘길예정입니다.
    @Transactional
    public AnDto deleteAnniverSary(AnDto anDto) {
        anRepository.deleteById(anDto.getId());
        return anDto;
    }

    @Transactional(readOnly = true)
    public AnResDto getAnniverSary(AnDto anDto) {
        return AnResDto.of(anRepository.findById(anDto.getId()).orElseThrow(EntityNotFoundException::new).creatAnniversary());
    }

    @Transactional(readOnly = true)
    public List<AnResDto> getAnniverSaryList() {
        List<AnResDto> anReqDtos = new ArrayList<>();
        anRepository.findAll().forEach(entity -> {
            anReqDtos.add(entity.creatAnniversary().createAnReqDto());
        });
        return anReqDtos;
    }

    //	NOTE: 현재 시간 <-> Dday 몇일 남았는지 계산하는 메서드
    private long getNowAnniverSary(LocalDateTime anniverSary) {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.DAYS.between(now, anniverSary);
    }

    // 기념일 찾기기능
//    private AnResDto findAnniverSary(AnDto){
//
//    }
}
