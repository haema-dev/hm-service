package me.hmservice.redis;

import java.util.NoSuchElementException;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RedisService {
  private final ReactiveRedisOperations<String, Person> redisOps;

  public RedisService(ReactiveRedisOperations<String, Person> redisOps) {
    this.redisOps = redisOps;
  }

  public Flux<Person> getAll() {
    return redisOps.keys("*")
        .flatMap(redisOps.opsForValue()::get);
  }
  public Mono<Person> getRedisValue(String key) {
    System.out.println("key: " + key);
    return redisOps.opsForValue().get(key)
        .flatMap(person -> {
          if (person != null) {
            return Mono.just(person);
          } else {
            return Mono.error(new NoSuchElementException("No value found for key " + key));
          }
        });
  }


  public Mono<Boolean> successRedisValue(Person person) {
    return redisOps.opsForValue().set(person.getId(), person);
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