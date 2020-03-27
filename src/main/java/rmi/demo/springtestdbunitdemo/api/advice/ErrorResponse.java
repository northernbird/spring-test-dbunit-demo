package rmi.demo.springtestdbunitdemo.api.advice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {

  private List<Error> errors = new ArrayList();

  public ErrorResponse() {
  }

  public static ErrorResponse error(String errorMessage) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.errors.add(new Error(errorMessage));
    return errorResponse;
  }

  public void addError(String errorMessage) {
    this.errors.add(new Error(errorMessage));
  }

}
