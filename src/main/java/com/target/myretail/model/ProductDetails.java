package com.target.myretail.model;

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

  public static class CurrentPrice {

    private double value;
    private String currency_code;
  }
}
