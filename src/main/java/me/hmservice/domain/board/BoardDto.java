package me.hmservice.domain.board;


public record BoardDto(
    String title,
    String content,
    String member_id
) {

    public Board build() {
      return new Board(title, content, member_id, null);
    }
  
}