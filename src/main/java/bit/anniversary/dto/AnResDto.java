package bit.anniversary.dto;

import org.modelmapper.ModelMapper;

import lombok.Builder;

@Builder
public class AnResDto {

	private final Long id;

	private final String writetime;

	private final String title;

	private final String withpeople;

	private final String content;

	private static ModelMapper modelMapper = new ModelMapper();

	public static AnResDto of(AnDto anDto) {
		return modelMapper.map(anDto, AnResDto.class);
	}

}
