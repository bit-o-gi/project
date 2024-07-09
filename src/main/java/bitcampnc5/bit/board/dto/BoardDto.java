package bitcampnc5.bit.board.dto;

import lombok.Builder;

@Builder
public record BoardDto(
	long id,
	String name,
	String releaseDate
) {

}
