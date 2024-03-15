package me.hmservice.user;

import me.hmservice.domain.board.Board;
import me.hmservice.user.board.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

  private final BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Transactional
  public Board createBoard(Board board) {
    return boardRepository.save(board);
  }
}
