package bitcampnc5.bit.board.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import bitcampnc5.bit.board.entity.Board;

public interface BoardRepogitory extends JpaRepository<Board, Long> {
}
