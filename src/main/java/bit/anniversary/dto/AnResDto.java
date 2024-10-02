package bit.anniversary.dto;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;

@Component
@Getter
public class AnResDto {

	private Long id;

	private String writeTime;

	private String title;

	private String writer;

	private String withPeople;

	private String updateTime;

	private String content;

	private LocalDateTime anniversaryDate;

	private static ModelMapper modelMapper;

	@Autowired
	public AnResDto(ModelMapper modelMapper) {
		AnResDto.modelMapper = modelMapper; // 수정된 부분
	}

	public static AnResDto of(AnDto anDto) {
		return modelMapper.map(anDto, AnResDto.class);
	}

}
