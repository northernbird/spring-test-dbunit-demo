package rmi.demo.springtestdbunitdemo.api.advice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException {
  private String errorMessage;

  public BadRequestException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

}
