package bitcampnc5.bit.board.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import bitcampnc5.bit.board.dto.BoardDto;
import lombok.Builder;

@Controller
public class BoardController {


	private String testAString = "testAString";

	@QueryMapping
	public String testA() {
		return testAString;
	}

	@QueryMapping
	public BoardDto GetBoard(@Argument Long id) {
		return null ;
	}

	@QueryMapping
	public List<BoardDto> GetBoards() {
		return null;
	}


	@MutationMapping
	public String someMethodUpdate(@Argument String changeValue) {
		testAString = changeValue;
		return testAString;
	}

	@MutationMapping
	public String testAUpdate(@Argument String changeValue) {
		testAString = changeValue;
		return testAString;
	}

}
