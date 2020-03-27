package rmi.demo.springtestdbunitdemo.api.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import rmi.demo.springtestdbunitdemo.api.advice.exception.BadRequestException;
import rmi.demo.springtestdbunitdemo.api.advice.exception.NotFoundException;
import java.util.Locale;

@ControllerAdvice
public class ExceptionHandlerAdvice {

  @Autowired
  MessageSource messageSource;

  public ExceptionHandlerAdvice() {
  }

  @ExceptionHandler( {MethodArgumentNotValidException.class})
  @ResponseBody
  public ResponseEntity<ErrorResponse> processValidationError(MethodArgumentNotValidException ex) {
    ErrorResponse validationError = new ErrorResponse();
    Locale currentLocale = LocaleContextHolder.getLocale();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      String errorMessage = this.messageSource.getMessage(error, currentLocale);
      validationError.addError(errorMessage);
    }

    return ResponseEntity.badRequest().body(validationError);
  }

  @ExceptionHandler( {BadRequestException.class})
  @ResponseBody
  public ResponseEntity<ErrorResponse> processBadRequestError(BadRequestException ex) {
    return ResponseEntity.badRequest().body(ErrorResponse.error(ex.getErrorMessage()));
  }

  @ExceptionHandler( {NotFoundException.class})
  @ResponseBody
  public ResponseEntity<ErrorResponse> processNotFoundError(NotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.error(ex.getErrorMessage()));
  }

}
