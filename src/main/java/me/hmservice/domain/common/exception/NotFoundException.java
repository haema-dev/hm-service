package me.hmservice.domain.common.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }

  // 비즈니스적으로 NotFound 하위 Exception 은 내부객체로 작성
  @Getter
  public static class BoardNotFoundException extends NotFoundException {
    public BoardNotFoundException(String message) {
      super(message);
    }
  }
}
