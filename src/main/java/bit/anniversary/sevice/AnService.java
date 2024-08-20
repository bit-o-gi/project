package bit.anniversary.sevice;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.anniversary.dto.AnDto;
import bit.anniversary.dto.AnReqDto;
import bit.anniversary.repository.AnRepository;
import bit.board.dto.BoardDto;
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
	public AnReqDto getAnniverSary(AnDto anDto) {
		return AnReqDto.of(anRepository.findById(anDto.getId()).orElseThrow(EntityNotFoundException::new).creatAnniversary());
	}

	@Transactional(readOnly = true)
	public List<AnReqDto> getAnniverSaryList() {
		List<AnReqDto> anReqDtos = new ArrayList<>();
		anRepository.findAll().forEach(entity -> {
			anReqDtos.add(entity.creatAnniversary().createAnReqDto());
		});
		return anReqDtos;
	}

}
