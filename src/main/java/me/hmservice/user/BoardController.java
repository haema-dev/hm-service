package me.hmservice.user;

import me.hmservice.domain.board.Board;
import me.hmservice.domain.board.BoardReq;
import me.hmservice.domain.common.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
  private final BoardService boardService;

  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @PostMapping
  public ResponseEntity<Result<Board>> createBoard(@RequestBody BoardReq createBoardRequest) {

    return ResponseEntity.status(HttpStatus.CREATED).body(
            Result.success(boardService.createBoard(createBoardRequest.build()))
          );
  }

  @GetMapping("/{id}")
  public ResponseEntity<Result<Board>> getBoard(@PathVariable Long id) {

    return ResponseEntity.status(HttpStatus.OK).body(
        Result.success(boardService.getBoard(id))
    );
  }

}
