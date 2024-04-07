package me.hmservice.domain.auth;


import java.io.Serializable;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;


@Getter
@RedisHash
public class Token implements Serializable {
  private String id;
  private String token;

  public Token() {}

  public Token(String id, String token) {
    this.id = id;
    this.token = token;
  }
}
