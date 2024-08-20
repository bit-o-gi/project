package bit.anniversary.sevice;

import org.springframework.stereotype.Service;

import bit.anniversary.dto.AnDto;
import bit.anniversary.repository.AnRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnService {

	private final AnRepository anRepository;

	public AnDto saveAnniverSary(AnDto andto) {
		return anRepository.save(andto.creatAnniversary()).creatAnniversary();
	}
}
