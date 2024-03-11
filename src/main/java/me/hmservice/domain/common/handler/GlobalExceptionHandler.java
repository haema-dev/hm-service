package me.hmservice.domain.common.handler;


import io.netty.handler.codec.http.HttpResponseStatus;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.hmservice.domain.common.error.ErrorCode;
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

    return ResponseEntity.status(HttpResponseStatus.BAD_REQUEST.code()).body(
        new Result<>(HttpResponseStatus.BAD_REQUEST.code(), "해당 데이터를 찾을 수 없습니다. -> "
            , new ErrorCode(HttpResponseStatus.BAD_REQUEST.code(), e.getMessage()))
    );
  }
}