package com.myretail.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.exception.ApplicationException;
import com.myretail.model.ProductDetails.CurrentPrice;
import com.myretail.repository.PriceDetailsRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPriceServiceImpl implements DefaultPriceService {

  @Autowired
  ObjectMapper mapper;

  @Autowired
  PriceDetailsRepository priceDetailsRepository;

  private static final List<Integer> productIdList = Arrays
      .asList(13860428, 15117729, 16483589, 16696652, 16752456);

  @Override
  public void setDefaultPriceDetails() {
    double leftLimit = 10D;
    double rightLimit = 50D;
    productIdList.stream().forEach(productId -> {
      CurrentPrice currentPrice = new CurrentPrice();
      currentPrice.setCurrency_code("USD");
      currentPrice.setValue(leftLimit + new Random().nextDouble() * (rightLimit - leftLimit));
      try {
        priceDetailsRepository
            .put(String.valueOf(productId), mapper.writeValueAsString(currentPrice));
      } catch (JsonProcessingException e) {
        throw new ApplicationException("Unable to assign default values");
      }
    });
  }
}
