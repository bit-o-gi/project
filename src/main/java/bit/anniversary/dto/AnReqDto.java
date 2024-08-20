package bit.anniversary.dto;

import org.modelmapper.ModelMapper;

import bit.board.dto.BoardDto;
import bit.board.dto.BoardReqDto;
import lombok.Builder;

@Builder
public class AnReqDto {

	private final Long id;

	private final String writetime;

	private final String title;

	private final String withpeople;

	private final String content;

	private static ModelMapper modelMapper = new ModelMapper();

	public static AnReqDto of(AnDto anDto) {
		return modelMapper.map(anDto, AnReqDto.class);
	}

}
