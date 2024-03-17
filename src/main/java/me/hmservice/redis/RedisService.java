package me.hmservice.redis;

import lombok.extern.slf4j.Slf4j;
import me.hmservice.domain.person.Person;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService {

  // Config 에서 설정해놓은 Template 사용
  private final RedisTemplate<String, String> redis;

  public RedisService(RedisTemplate<String, String> redis) {
    this.redis = redis;
  }


  public Person findByKeyInRedis(String key) {
    log.info("key: " + key);
    // TODO: redis에 key에 해당하는 value가 없을 경우 예외처리
    String name = redis.opsForValue().get(key).toString();
    return new Person(key, name);
  }


  public void successRedisValue(Person person) {
    redis.opsForValue().set(person.getId(), person.getName());
  }

  public Person setRedisValue(Person person) {
    successRedisValue(person);
    return new Person(person.getId(), person.getName());
  }
}