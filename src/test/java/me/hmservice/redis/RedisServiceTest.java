//package me.hmservice.redis;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static reactor.core.publisher.Mono.when;
//
//import me.hmservice.domain.person.Person;
//import me.hmservice.redis.config.RedisConfig;
//import net.bytebuddy.utility.dispatcher.JavaDispatcher.Container;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.redis.core.ReactiveRedisTemplate;
//import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
//import org.springframework.data.redis.core.ReactiveValueOperations;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//public class RedisServiceTest {
//
//  @InjectMocks
//  RedisService redisService;
//
//
//  @Test
//  public void findByKeyInRedisTest() {
//    // Mock the ReactiveValueOperations
//    ReactiveValueOperations<String, String> valueOps = mock(ReactiveValueOperations.class);
//
//    // Setup the mock behavior for opsForValue
////    when(reactiveStringRedisTemplate).thenReturn(valueOps);
//
//    String key = "1";
//    String name = "김철수";
//
//    // Define behavior for get method of valueOps
//    when(valueOps.get(key)).thenReturn(Mono.just(name));
//
//    StepVerifier.create(redisService.findByKeyInRedis(key))
//        .assertNext(person -> {
//          assertAll("Person",
//              () -> assertEquals(key, person.getId()),
//              () -> assertEquals(name, person.getName())
//          );
//        })
//        .verifyComplete();
//  }
////
////  @Test
////  public void setRedisValueTest() {
////    Person person = new Person("1", "Alice");
////    when(reactiveRedisTemplate.opsForValue().set(person.getId(), person.getName())).thenReturn(Mono.just(true));
////
////    StepVerifier.create(redisService.setRedisValue(person))
////        .assertNext(p -> assertEquals(person, p))
////        .verifyComplete();
////  }
//}