package me.hmservice.user;

import me.hmservice.domain.board.Board;
import me.hmservice.domain.board.BoardDto;
import me.hmservice.domain.common.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Result<Board>> createBoard(@RequestBody BoardDto createBoardRequest) {

    return ResponseEntity.status(HttpStatus.CREATED).body(
            Result.success(boardService.createBoard(createBoardRequest.build()))
          );
  }

//  // 성공 예시
//  Result<String> successResult = Result.success("성공적인 처리 결과");
//
//  // 실패 예시
//  Result<String> failureResult = Result.failure("처리 중 에러 발생");

}
