package bitcampnc5.bit.board.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bitcampnc5.bit.board.dto.BoardDto;
import bitcampnc5.bit.board.dto.BoardReqDto;
import bitcampnc5.bit.board.entity.Board;
import bitcampnc5.bit.board.repogitory.BoardRepogitory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private BoardRepogitory boardRepogitory;

	//	TODO: Exception 잡아야됨
	@Transactional()
	public BoardDto GetBoardService(BoardDto boardDto) {

		return BoardDto.of(boardRepogitory.findById(boardDto.getId()).orElseThrow(EntityNotFoundException::new));
	}

	@Transactional()
	public List<BoardDto> getBoardList() {
		List<BoardDto> boardlist = new ArrayList<>();
		boardRepogitory.findAll().forEach(entity -> {
			boardlist.add(new ModelMapper().map(entity, BoardDto.class));
		});
		return boardlist;
	}

	public BoardReqDto CreateBoard(BoardDto boardInput) {
		Board entity = Board.builder()
			.title(boardInput.getTitle())
			.content(boardInput.getContent())
			.build();
		return BoardReqDto.of(BoardDto.of(boardRepogitory.save(entity)));
	}

	public BoardReqDto UpdateBoard(BoardDto boardInput) {
		Board board = boardRepogitory.findById(boardInput.getId())
			.orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
		board.setTitle(boardInput.getTitle());
		board.setContent(boardInput.getContent());

		Board savedBoard = boardRepogitory.save(board);
		return BoardReqDto.of(BoardDto.of(savedBoard));
	}

	public void delete(Long id) {
		Board board = boardRepogitory.findById(id)
			.orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
		boardRepogitory.delete(board);
	}
}
