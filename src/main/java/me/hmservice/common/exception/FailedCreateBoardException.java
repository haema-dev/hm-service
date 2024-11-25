package me.hmservice.common.exception;

import lombok.Getter;

@Getter
public class FailedCreateBoardException extends RuntimeException {

  public FailedCreateBoardException(String message) {
    super(message);
  }
}
