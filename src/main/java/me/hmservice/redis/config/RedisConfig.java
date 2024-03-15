package me.hmservice.redis.config;

import me.hmservice.domain.person.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

  @Value("${spring.data.redis.host}")
  private String host;
  @Value("${spring.data.redis.port}")
  private int port;

  /**
   * redis 실행 :  redis-server --port 6375
   * cli 접속   :  redis-cli -p 6375
   **/


  // RedisConnectionFactory 설정
  @Bean
  public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
    return new LettuceConnectionFactory(host, port);
  }

  // Reactive 에서는 ReactiveRedisTemplate 사용을 권장
  // Serializer 세팅
  @Bean
  public ReactiveRedisTemplate<String, String> reactiveRedisTemplate() {
    RedisSerializer<String> key = new StringRedisSerializer();
    Jackson2JsonRedisSerializer<String> value = new Jackson2JsonRedisSerializer<>(String.class);
    RedisSerializationContext<String, String> serializationContext = RedisSerializationContext
        .<String, String>newSerializationContext()
        .key(key)
        .value(value)
        .hashKey(key)
        .hashValue(value)
        .build();

    return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory(), serializationContext);
  }
}