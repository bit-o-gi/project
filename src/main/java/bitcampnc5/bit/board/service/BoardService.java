package bitcampnc5.bit.board.service;

import bitcampnc5.bit.board.dto.BoardReqDto;
import bitcampnc5.bit.board.entity.Board;
import bitcampnc5.bit.board.repogitory.BoardRepogitory;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import bitcampnc5.bit.board.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


}
