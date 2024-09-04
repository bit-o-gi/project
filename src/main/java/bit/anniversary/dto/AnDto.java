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

	private String writer;

	private String title;

	private String withpeople;

	private String content;

	private LocalDateTime antime;

	private static ModelMapper modelMapper;

	@Autowired
	public AnDto(ModelMapper modelMapper) {
		AnDto.modelMapper = modelMapper; // 수정된 부분
	}
	public Anniversary creatAnniversary() {
		return modelMapper.map(this, Anniversary.class);
	}

	public AnResDto createAnReqDto() {
		return modelMapper.map(this, AnResDto.class);
	}

	public static AnDto of(Anniversary anniversary) {
		return modelMapper.map(anniversary, AnDto.class);
	}

}
