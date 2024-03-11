package me.hmservice.domain.common.result;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Result<T> {

  private int status;
  private String message;
  private T data;

  public Result() {}

  @Builder
  public Result(int status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

}
