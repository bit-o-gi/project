package bitcampnc5.bit.board.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardDto{
	private Long id;

	private String title;

	private String content;
}
