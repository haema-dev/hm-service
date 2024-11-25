package me.hmservice.domain.board.repo;


import me.hmservice.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

}
