package me.hmservice.redis;

import java.util.NoSuchElementException;
import me.hmservice.redis.config.RedisConfig;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RedisService {

  // Config 에서 설정해놓은 Template 사용
  private final ReactiveStringRedisTemplate reactiveRedis;

  public RedisService(ReactiveStringRedisTemplate reactiveStringRedisTemplate) {
    this.reactiveRedis = reactiveStringRedisTemplate;
  }


  public Mono<Person> findByKeyInRedis(String key) {
    System.out.println("key: " + key);
    return reactiveRedis.opsForValue().get(key).map(data -> new Person(key, data));
  }


  public Mono<Boolean> successRedisValue(Person person) {
    return reactiveRedis.opsForValue().set(person.getId(), person.getName());
  }

  public Mono<Person> setRedisValue(Person person) {
    return successRedisValue(person)
        .flatMap(success -> {
          if (success) {
            System.out.println("person: " + person.getId() + ", " + person.getName());
            return Mono.just(person);
          } else {
            return Mono.error(new Exception("Could not save person " + person.getId()));
          }
        });

  }
}