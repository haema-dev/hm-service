package me.hmservice.admin;

import me.hmservice.domain.board.BoardReq;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

  public Object createBoard(BoardReq board) {
    return board;
  }
}
