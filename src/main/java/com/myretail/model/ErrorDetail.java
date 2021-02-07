package com.myretail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorDetail {

  @JsonProperty("message")
  private String errorDescription;

  public ErrorDetail(String errorDescription) {
    super();
    this.errorDescription = errorDescription;
  }

}
