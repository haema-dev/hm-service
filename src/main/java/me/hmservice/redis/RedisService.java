package me.hmservice.redis;

import java.util.Optional;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import me.hmservice.common.exception.NotFoundException.KeyNotFoundException;
import me.hmservice.domain.person.Person;
import me.hmservice.redis.config.RedisConfig;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class RedisService {

  // Config 에서 설정해놓은 Template 사용
  private final RedisConfig redisConfig;

  public RedisService(RedisConfig redisConfig) {
    this.redisConfig = redisConfig;
  }

  private <T> Optional<T> executeRedisOperation(Supplier<T> redisOperation) {
    try {
      return Optional.ofNullable(redisOperation.get());
    } catch (RedisConnectionFailureException e) {
      log.error("Redis error: ", e);
      return Optional.empty();
    }
  }

//  public Person findByKeyInRedis(String key) {
//    log.info("key: " + key);
//    return Optional.ofNullable(redisConfig.redisTemplate().opsForValue().get(key))
//        .map(name -> new Person(key, name))
//        .orElseThrow(() -> new KeyNotFoundException("Redis 에서 해당 키를 찾을 수 없습니다 -> : " + key));
//  }
  public Person findByKeyInRedis(String key) {
    log.info("key: " + key);
    return executeRedisOperation(() -> redisConfig.redisTemplate().opsForValue().get(key))
        .map(name -> new Person(key, name))
        .orElseThrow(() -> new KeyNotFoundException("Redis 에서 해당 키를 찾을 수 없습니다 -> : " + key));
  }

  public void successRedisValue(Person person) {
    redisConfig.redisTemplate().opsForValue().set(person.getId(), person.getName());
  }

  public Person setRedisValue(Person person) {
    successRedisValue(person);
    return new Person(person.getId(), person.getName());
  }
}