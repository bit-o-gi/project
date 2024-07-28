package bit.board.dto;

import bit.board.entity.Board;
import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	// TODO : 글쓴 날짜 , 유저 정보 , 필요
	private Long id;

	private String title;

	private String content;

	private String writer;

	private static ModelMapper modelMapper = new ModelMapper();

	public Board creatBoard() {
		return modelMapper.map(this, Board.class);
	}

	public static BoardDto of(Board board) {
		return modelMapper.map(board, BoardDto.class);
	}
}
