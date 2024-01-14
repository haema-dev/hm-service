package me.hmservice.redis;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RedisController {
  private final RedisService redisService;

  public RedisController(RedisService redisService) {
    this.redisService = redisService;
  }

  @GetMapping("/redis")
  public ResponseEntity<Flux<Person>> all() {
    return ResponseEntity.status(HttpStatus.OK).body(redisService.getAll());
  }

  @GetMapping("/redis/{id}")
  public ResponseEntity<Mono<Person>> getRedisValue(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body(redisService.getRedisValue(id));
  }

  @PostMapping("/redis")
  public ResponseEntity<Mono<Person>> setRedisValue(@RequestBody Person person) {
    return ResponseEntity.status(HttpStatus.CREATED).body(redisService.setRedisValue(person));
  }

}