package me.hmservice.redis;


import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;


@RedisHash
public class Person implements Serializable {
  private String id;
  private String name;

  public Person() {}

  public Person(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
