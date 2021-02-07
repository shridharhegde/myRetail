package com.myretail.service;

import com.myretail.model.ProductDetails;
import org.springframework.stereotype.Service;

@Service
public interface ProductDescriptionService {

  ProductDetails getProductDescription(long productId);
}
