package me.hmservice.common.handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.hmservice.common.error.ErrorCode;
import me.hmservice.common.exception.InvalidInputException;
import me.hmservice.common.exception.NotFoundException.BoardNotFoundException;
import me.hmservice.common.exception.NotFoundException.KeyNotFoundException;
import me.hmservice.common.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = Logger.getLogger(String.valueOf(GlobalExceptionHandler.class));

  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<Result<ErrorCode>> handleInvalidInputException(InvalidInputException e) {
    logger.log(Level.WARNING, "[InvalidInputException] : ", e);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        Result.failure(ErrorCode.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .message(e.getMessage())
            .build())
    );
  }

  @ExceptionHandler(BoardNotFoundException.class)
  public ResponseEntity<Result<ErrorCode>> handleBoardNotFoundException(BoardNotFoundException e) {
    logger.log(Level.WARNING, "[BoardNotFoundException] : ", e);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
        Result.failure(ErrorCode.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .message(e.getMessage())
            .build())
    );
  }

  @ExceptionHandler(KeyNotFoundException.class)
  public ResponseEntity<Result<ErrorCode>> handleBoardNotFoundException(KeyNotFoundException e) {
    logger.log(Level.WARNING, "[KeyNotFoundException] : ", e);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
        Result.failure(ErrorCode.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .message(e.getMessage())
            .build())
    );
  }
}