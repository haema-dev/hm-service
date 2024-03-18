package me.hmservice.common.result;

import me.hmservice.common.error.ErrorCode;

public record Result<T>(T data, ErrorCode response, boolean isSuccess) {

  public static <T> Result<T> success(T data) {
    return new Result<>(data, null, true);
  }

  public static <T> Result<T> failure(ErrorCode response) {
    return new Result<>(null, response, false);
  }
}