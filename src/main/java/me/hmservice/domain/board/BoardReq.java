package me.hmservice.domain.board;


import java.sql.Timestamp;
import java.time.LocalDateTime;

public record BoardReq(
    String title,
    String content,
    String member_id
) {

    public Board build() {
      return new Board(title, content, member_id, Timestamp.valueOf(LocalDateTime.now()));
    }
  
}