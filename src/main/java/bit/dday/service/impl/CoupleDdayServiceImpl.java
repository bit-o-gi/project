package bit.dday.service.impl;

import bit.dday.dto.CoupleDdayDto;
import bit.dday.entity.CoupleDday;
import bit.dday.repogsitory.CoupleDdayRepository;
import bit.dday.service.CoupleDdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoupleDdayServiceImpl implements CoupleDdayService {

    @Autowired
    private CoupleDdayRepository coupleDdayRepository;

    @Override
    public CoupleDdayDto registerDday(CoupleDdayDto dto) {
        CoupleDday coupleDday = new CoupleDday();
        coupleDday.setPartner1(dto.getPartner1());
        coupleDday.setPartner2(dto.getPartner2());
        coupleDday.setDdayDate(dto.getDdayDate());

        CoupleDday savedCoupleDday = coupleDdayRepository.save(coupleDday);

        CoupleDdayDto responseDto = new CoupleDdayDto();
        responseDto.setPartner1(savedCoupleDday.getPartner1());
        responseDto.setPartner2(savedCoupleDday.getPartner2());
        responseDto.setDdayDate(savedCoupleDday.getDdayDate());

        return responseDto;
    }

}
