package me.hmservice.domain.common.result;


import me.hmservice.domain.common.ResponseCode;

public record Result<T>(T data, ResponseCode response, boolean isSuccess) {

  public static <T> Result<T> success(T data) {
    return new Result<>(data, null, true);
  }

  public static <T> Result<T> failure(ResponseCode response) {
    return new Result<>(null, response, false);
  }
}
