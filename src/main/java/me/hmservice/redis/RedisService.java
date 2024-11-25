package me.hmservice.redis;

import java.util.Optional;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import me.hmservice.common.exception.NotFoundException.KeyNotFoundException;
import me.hmservice.domain.auth.Token;
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

  public Token findByKeyInRedis(String key) {
    log.info("key: " + key);
    return executeRedisOperation(() -> redisConfig.redisTemplate().opsForValue().get(key))
        .map(name -> new Token(key, name))
        .orElseThrow(() -> new KeyNotFoundException("Redis 에서 해당 키를 찾을 수 없습니다 -> : " + key));
  }

  public void successRedisValue(Token token) {
    redisConfig.redisTemplate().opsForValue().set(token.getId(), token.getToken());
  }

  public Token setRedisValue(Token token) {
    successRedisValue(token);
    return new Token(token.getId(), token.getToken());
  }
}