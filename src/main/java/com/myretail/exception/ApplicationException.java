package com.myretail.exception;

public class ApplicationException extends RuntimeException {

  public ApplicationException(final String message) {
    super(message);
  }
}
