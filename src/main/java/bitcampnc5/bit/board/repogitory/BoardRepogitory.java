package bitcampnc5.bit.board.repogitory;


import bitcampnc5.bit.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepogitory extends JpaRepository<Board,Long> {
}
