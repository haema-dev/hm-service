package me.hmservice.redis;


import me.hmservice.common.result.Result;
import me.hmservice.domain.person.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
  private final RedisService redisService;

  public RedisController(RedisService redisService) {
    this.redisService = redisService;
  }

  @GetMapping("/redis/{id}")
  public ResponseEntity<Result<Person>> getRedisValue(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body(
        Result.success(redisService.findByKeyInRedis(id))
    );
  }

  @PostMapping("/redis")
  public ResponseEntity<Result<Person>> setRedisValue(@RequestBody Person person) {
    return ResponseEntity.status(HttpStatus.CREATED).body(
        Result.success(
            redisService.setRedisValue(person)
        )
    );
  }

}