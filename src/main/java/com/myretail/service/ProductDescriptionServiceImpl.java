package com.myretail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.exception.ApplicationException;
import com.myretail.model.ProductDetails;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {


  private static final String PRODUCT_DETAILS = "[{\"id\":13860428,\"name\":\"The Big Lebowski (Blu-ray) (Widescreen)\"},{\"id\":15117729,\"name\":\"iPhone SE\"},{\"id\":16483589,\"name\":\"iPhone XR\"},{\"id\":16696652,\"name\":\"iPhone 11\"},{\"id\":16752456,\"name\":\"Samsung A21\"}]";

  @Autowired
  ObjectMapper mapper;

  @Override
  public ProductDetails getProductDescription(long productId) {
    if (productId <= 0) {
      throw new ApplicationException("Product Id can not be empty");
    }

    try {
      List<ProductDetails> productDetailsList = Arrays
          .asList(
              mapper.readValue(PRODUCT_DETAILS,
                  ProductDetails[].class));
      if (Optional.ofNullable(productDetailsList).isPresent() && !productDetailsList.isEmpty()) {
        return productDetailsList.stream()
            .filter(productDetails -> productDetails.getId() == productId).findFirst().get();
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new ApplicationException("Unable to get product details");
    }
    return null;
  }
}
