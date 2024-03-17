package me.hmservice.domain.person;


import java.io.Serializable;

import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;


@Getter
@RedisHash
public class Person implements Serializable {
  private String id;
  private String name;

  public Person() {}

  public Person(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
