package me.hmservice.admin;

import me.hmservice.domain.board.BoardReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

  private AdminService adminService;

  @PostMapping
  public Object createBoard(@RequestBody BoardReq board) {
    return adminService.createBoard(board);
  }

}
