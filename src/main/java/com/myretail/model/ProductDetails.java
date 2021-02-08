package com.myretail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetails implements Serializable {

  private long id;
  private String name;
  private CurrentPrice current_price;

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Data
  public static class CurrentPrice implements Serializable {

    private double value;
    private String currency_code;
  }
}
