package me.hmservice.domain.common.handler;

import java.util.logging.Logger;

import me.hmservice.domain.common.error.ErrorCode;
import me.hmservice.domain.common.exception.InvalidInputException;
import me.hmservice.domain.common.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger log = Logger.getLogger(String.valueOf(GlobalExceptionHandler.class));

  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<Result<ErrorCode>> handleIllegalArgumentException(InvalidInputException e) {
    Result<ErrorCode> failureResult
            = Result.failure(ErrorCode.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(e.getMessage())
                    .build());

    log.warning(e.getMessage());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResult);
  }
}