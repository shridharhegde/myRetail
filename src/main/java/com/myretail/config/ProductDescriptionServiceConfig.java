package com.myretail.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "product-description.api")
@Configuration("productDescriptionApiProperties")
@Data
public class ProductDescriptionServiceConfig {

  private String host;
  private String productDescription;
}
