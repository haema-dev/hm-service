package me.hmservice.common.exception;

import lombok.Getter;

@Getter
public class InvalidInputException extends RuntimeException {

  public InvalidInputException(String message) {
    super(message);
  }
}
