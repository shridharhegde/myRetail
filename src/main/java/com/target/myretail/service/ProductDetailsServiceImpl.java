package com.target.myretail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.myretail.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

  @Autowired
  ObjectMapper mapper;

  @Override
  public ProductDetails getProductDetails(long productId) {
    return null;
  }

  @Override
  public void updateProductDetails(ProductDetails productDetails) {

  }
}
