package com.myretail.exception;

import com.myretail.model.ErrorDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@Slf4j
public class ApplicationExceptionHandler {

  @ExceptionHandler(value = ApplicationException.class)
  public ErrorDetail handleApplicationException(ApplicationException e) {
    log.error("Exception occurred due to : ", e);
    return new ErrorDetail(e.getMessage());
  }
}
