package me.hmservice.user;

import io.micrometer.common.util.StringUtils;
import me.hmservice.domain.board.Board;
import me.hmservice.domain.common.exception.NotFoundException;
import me.hmservice.user.board.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BoardService {

  private final BoardRepository boardRepository;

  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Transactional
  public Board createBoard(Board board) {
    return Optional.of(board)
            .filter(this::isValidBoard)
            .map(boardRepository::save)
            .map(Board::getId)
            .flatMap(boardRepository::findById)
            .orElseThrow(() -> new NotFoundException("해당하는 게시글이 없습니다."));
  }

  private boolean isValidBoard(Board board) {
    return !StringUtils.isBlank(board.getTitle()) &&
            !StringUtils.isBlank(board.getContent()) &&
            !StringUtils.isBlank(board.getMember_id());
  }
}