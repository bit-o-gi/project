package bit.anniversary.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;

@Component
@Getter
public class AnResDto {

	private Long id;

	private String writetime;

	private String title;

	private String withpeople;

	private String content;

	private static ModelMapper modelMapper;

	@Autowired
	public AnResDto(ModelMapper modelMapper) {
		AnResDto.modelMapper = modelMapper; // 수정된 부분
	}

	public static AnResDto of(AnDto anDto) {
		return modelMapper.map(anDto, AnResDto.class);
	}

}
