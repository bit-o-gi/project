package bit.anniversary.dto;

import org.modelmapper.ModelMapper;

import bit.anniversary.entity.Anniversary;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class AnDto {

	private final Long id;

	private final String writer;

	private final String title;

	private final String withpeople;

	private final String content;

	private LocalDateTime antime;

	private static ModelMapper modelMapper = new ModelMapper();

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
