package me.hmservice.domain.board;

import me.hmservice.domain.common.exception.InvalidInputException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// record 는 내부에 자동으로 생성자, getter, equals, hashCode, toString 메소드를 생성해준다.
public record BoardReq(
    String title,
    String content,
    String member_id
) {

    // 콤팩트 생성자 - 여기에서 유효성 검사나 초기화 로직을 제공할 수 있습니다.
    public BoardReq {
        // isBlank 는 문자열이 비어있거나 공백으로만 이루어져있는지 확인하는 메소드
        if (title == null || title.isBlank()) {
            throw new InvalidInputException("title is blank");
        }
        if (content == null || content.isBlank()) {
            throw new InvalidInputException("content is blank");
        }
    }

    public Board build() {
      return new Board(title, content, member_id, Timestamp.valueOf(LocalDateTime.now()));
    }
  
}