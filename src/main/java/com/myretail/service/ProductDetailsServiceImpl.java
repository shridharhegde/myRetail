package com.myretail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.config.ProductDescriptionServiceConfig;
import com.myretail.config.RedisConfiguration;
import com.myretail.exception.ApplicationException;
import com.myretail.model.ProductDetails;
import com.myretail.model.ProductDetails.CurrentPrice;
import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

  private static final String PRODUCT = "PRODUCT";

  @Autowired
  ObjectMapper mapper;

  @Autowired
  RedisConfiguration<CurrentPrice> redisConfiguration;

  @Autowired
  ProductDescriptionServiceConfig productDescriptionServiceConfig;

  @Override
  @Transactional
  public ProductDetails getProductDetails(long productId) {
    if (productId <= 0) {
      throw new ApplicationException("Product Id can not be empty");
    }
    ProductDetails productDetails = getProductDescription(productId);
    if (Optional.ofNullable(productDetails).isPresent()) {
      CurrentPrice currentPrice = (CurrentPrice) redisConfiguration.redisTemplate().opsForHash()
          .get(PRODUCT, String.valueOf(productId));
      if (Optional.ofNullable(currentPrice).isPresent()) {
        productDetails.setCurrent_price(currentPrice);
      }
      return productDetails;
    }
    return null;
  }

  @Override
  @Transactional
  public void updateProductPriceDetails(ProductDetails productDetails, long productId) {
    if (Optional.ofNullable(productDetails).isPresent() && Optional
        .ofNullable(productDetails.getCurrent_price()).isPresent()) {
      redisConfiguration.redisTemplate().opsForHash()
          .put(PRODUCT, String.valueOf(productId), productDetails.getCurrent_price());
    } else {
      throw new ApplicationException("Price details can not be empty");
    }
  }

  private ProductDetails getProductDescription(long productId) {
    String url = productDescriptionServiceConfig.getHost() + productDescriptionServiceConfig
        .getProductDescription();
    url = url.replace("{productId}", String.valueOf(productId));
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<ProductDetails> response = restTemplate
        .exchange(url, HttpMethod.GET, null, ProductDetails.class);
    if (Optional.ofNullable(response).isPresent()) {
      return response.getBody();
    }
    return null;
  }
}
