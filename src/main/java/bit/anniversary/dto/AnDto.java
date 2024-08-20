package bit.anniversary.dto;

import org.modelmapper.ModelMapper;

import bit.anniversary.entity.Anniversary;
import bit.board.dto.BoardDto;
import bit.board.dto.BoardReqDto;
import bit.board.entity.Board;
import lombok.Builder;

@Builder
public class AnDto {

	private final Long id;

	private final String writetime;

	private final String title;

	private final String withpeople;

	private final String content;

	private static ModelMapper modelMapper = new ModelMapper();

	public Anniversary creatAnniversary() {
		return modelMapper.map(this, Anniversary.class);
	}

	public AnReqDto createAnReqDto() {
		return modelMapper.map(this, AnReqDto.class);
	}

	public static AnDto of(Anniversary anniversary) {
		return modelMapper.map(anniversary, AnDto.class);
	}

}
