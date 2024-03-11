package me.hmservice.domain.common.error;


public class ErrorCode {
  private int code;
  private String message;

  public ErrorCode() {}

  public ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}