package bitcampnc5.bit.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import bitcampnc5.bit.board.dto.BoardDto;
import bitcampnc5.bit.board.dto.BoardReqDto;
import bitcampnc5.bit.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	private String testAString = "testAString";

	// TODO : 추후 삭제예정 코드
	@QueryMapping
	public String testA() {
		return testAString;
	}

	// TODO : 추후 삭제예정 코드
	@MutationMapping
	public String testAUpdate(@Argument String changeValue) {
		testAString = changeValue;
		return testAString;
	}

	@QueryMapping
	public BoardReqDto getBoard(@Argument Long id) {
		System.out.println("GetBoard");
		BoardDto boardDto = new BoardDto();
		boardDto.setId(id);
		return BoardReqDto.of(boardService.GetBoardService(boardDto));
	}

	@QueryMapping
	public List<BoardReqDto> getBoards() {
		List<BoardReqDto> boardReqDtos = new ArrayList<>();
		boardService.getBoardList().forEach(Entity -> {
			boardReqDtos.add(new ModelMapper().map(Entity, BoardReqDto.class));
		});
		return boardReqDtos;
	}

	@MutationMapping
	public BoardReqDto CreateBoard(@Argument BoardDto boardInput) {
		return boardService.CreateBoard(boardInput);
	}

	@MutationMapping
	public BoardReqDto UpdateBoard(@Argument BoardDto boardInput) {
		return boardService.UpdateBoard(boardInput);
	}

	@MutationMapping
	public Boolean delete(@Argument Long id) {
		boardService.delete(id);
		return true;
	}

}
