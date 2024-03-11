package me.hmservice.domain.common.exception;

import lombok.Getter;
import org.springframework.data.redis.RedisConnectionFailureException;

@Getter
public class ConnectionException extends RedisConnectionFailureException {

  public ConnectionException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
