package me.hmservice.redis;

import lombok.extern.slf4j.Slf4j;
import me.hmservice.domain.person.Person;
import me.hmservice.redis.config.RedisConfig;
import org.springframework.stereotype.Service;

// TODO: Connection 예외처리 추가
@Slf4j
@Service
public class RedisService {

  // Config 에서 설정해놓은 Template 사용
  private final RedisConfig redisConfig;

  public RedisService(RedisConfig redisConfig) {
    this.redisConfig = redisConfig;
  }


  public Person findByKeyInRedis(String key) {
    log.info("key: " + key);
    // TODO: redis에 key에 해당하는 value가 없을 경우 예외처리
    String name = redisConfig.redisTemplate().opsForValue().get(key).toString();
    return new Person(key, name);
  }


  public void successRedisValue(Person person) {
    redisConfig.redisTemplate().opsForValue().set(person.getId(), person.getName());
  }

  public Person setRedisValue(Person person) {
    successRedisValue(person);
    return new Person(person.getId(), person.getName());
  }
}