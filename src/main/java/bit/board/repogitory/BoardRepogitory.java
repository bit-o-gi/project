package bit.board.repogitory;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.board.entity.Board;

public interface BoardRepogitory extends JpaRepository<Board, Long> {
}
