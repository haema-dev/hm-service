package me.hmservice.domain.common.error;


import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorCode {
  private int code;
  private String message;

  public ErrorCode() {}

  @Builder
  public ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}