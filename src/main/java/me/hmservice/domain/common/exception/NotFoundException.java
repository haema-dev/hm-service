package me.hmservice.domain.common.exception;


import java.util.NoSuchElementException;
import lombok.Getter;

@Getter
public class NotFoundException extends NoSuchElementException {

  public NotFoundException(String s) {
  }

  public NotFoundException(String s, String message) {
  }
}
