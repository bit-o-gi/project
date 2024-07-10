package bitcampnc5.bit.board.controller;

import java.util.List;

import bitcampnc5.bit.User.dto.UserDto;
import bitcampnc5.bit.board.dto.BoardReqDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import bitcampnc5.bit.board.dto.BoardDto;
import bitcampnc5.bit.board.service.BoardService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {


    private final BoardService boardService;

    private String testAString = "testAString";

    @QueryMapping
    public String testA() {
        return testAString;
    }


    @QueryMapping
    public BoardReqDto getBoard(@Argument Long id) {
        System.out.println("GetBoard");
        BoardDto boardDto = new BoardDto();
        boardDto.setId(id);
        boardService.GetBoardService(boardDto);
        return null;
    }

    @QueryMapping
    public List<BoardReqDto> getBoards() {
        System.out.println("GetBoards");
        return null;
    }

    @MutationMapping
    public String someMethodUpdate(@Argument String changeValue) {
        testAString = changeValue;
        return testAString;
    }

    @MutationMapping
	public Boolean delete(@Argument Long id) {
		return true;
	}



	@MutationMapping
    public String testAUpdate(@Argument String changeValue) {
        testAString = changeValue;
        return testAString;
    }

}
