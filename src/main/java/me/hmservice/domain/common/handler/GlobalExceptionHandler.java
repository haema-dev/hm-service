package me.hmservice.domain.common.handler;


import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.hmservice.domain.common.result.Result;
import me.hmservice.domain.common.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private final Logger log = Logger.getLogger(String.valueOf(GlobalExceptionHandler.class));

  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<Result<?>> handleMethodArgumentNotValidException(NoSuchElementException e) {

    log.log(Level.parse("NotFoundException: {}, {} "), e.getMessage(), e.getStackTrace());

    return null;
  }
}