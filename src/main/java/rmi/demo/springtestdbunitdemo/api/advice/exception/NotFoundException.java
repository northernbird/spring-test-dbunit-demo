package rmi.demo.springtestdbunitdemo.api.advice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {
  private String errorMessage;

  public NotFoundException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

}
