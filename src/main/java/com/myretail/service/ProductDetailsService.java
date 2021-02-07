package com.myretail.service;

import com.myretail.model.ProductDetails;
import org.springframework.stereotype.Service;

@Service
public interface ProductDetailsService {

  ProductDetails getProductDetails(long productId);

  void updateProductDetails(ProductDetails productDetails);
}
