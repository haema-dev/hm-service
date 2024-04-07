package me.hmservice.user.board;

import io.micrometer.common.util.StringUtils;
import me.hmservice.domain.board.Board;
import me.hmservice.common.exception.FailedCreateBoardException;
import me.hmservice.common.exception.NotFoundException.BoardNotFoundException;
import me.hmservice.domain.board.repo.BoardRepository;
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
            .filter(this::isValidCreateBoard)
            .map(boardRepository::save)
          .orElseThrow(() -> new FailedCreateBoardException("게시글 작성에 실패하였습니다."));
  }

  @Transactional(readOnly = true)
  public Board getBoard(final Long id) {
    return boardRepository.findById(id)
        .orElseThrow(() -> new BoardNotFoundException("해당하는 게시글이 없습니다."));
  }

  private boolean isValidCreateBoard(Board board) {
    return !StringUtils.isBlank(board.getTitle()) &&
            !StringUtils.isBlank(board.getContent()) &&
            !StringUtils.isBlank(board.getMemberId());
  }
}