package com.myretail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

  @Autowired
  ObjectMapper mapper;

  @Override
  public ProductDetails getProductDescription(long productId) {
    return null;
  }
}
