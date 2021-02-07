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
import org.springframework.util.ResourceUtils;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {


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
              mapper.readValue(ResourceUtils.getFile("classpath:product_details.json"),
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
