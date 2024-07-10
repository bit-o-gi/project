package bitcampnc5.bit.board.dto;

import bitcampnc5.bit.User.dto.UserDto;
import bitcampnc5.bit.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto{
	private Long id;

	private String title;

	private String content;

	private String writer;

	private static ModelMapper modelMapper = new ModelMapper();

	public Board creatBoard(){
		return modelMapper.map(this,Board.class);
	}

	public static BoardDto of(Board board){
		return modelMapper.map(board,BoardDto.class);
	}
}
