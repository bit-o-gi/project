package bit.anniversary.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import bit.anniversary.dto.AnDto;
import bit.anniversary.dto.AnReqDto;
import bit.board.dto.BoardDto;
import bit.board.dto.BoardReqDto;

@Controller
public class anController {



	// 	TODO: 기념일 설정 기능
	// 	Input : 기념일 시간 , 입력 시간 , 수정 시간 , 기념일 제목 ,글쓴이 , 함께 하는 사람 ,기념일 내용
	// 	TODO: 함께 하는 사람 , 글쓴이 회원가입 이후 구현.
	@MutationMapping
	public AnReqDto createBoard(@Argument AnDto andto) {

		// return boardService.CreateBoard(boardInput);
		return null;
	}

}
