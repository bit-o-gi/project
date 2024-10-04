package bit.anniversary.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bit.anniversary.entity.Anniversary;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Component
public class AnDto {

	private Long id;

	private String writeTime;

	private String title;

	private String writer;

	private String withPeople;

	private String updateTime;

	private String content;

	private LocalDateTime anniversaryDate;


	public Anniversary creatAnniversary(ModelMapper modelMapper) {
		return modelMapper.map(this, Anniversary.class);
	}

	public AnResDto createAnReqDto(ModelMapper modelMapper) {
		return modelMapper.map(this, AnResDto.class);
	}

	public static AnDto of(Anniversary anniversary,ModelMapper modelMapper) {
		return modelMapper.map(anniversary, AnDto.class);
	}

}
