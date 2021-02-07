package com.target.myretail.service;

import com.target.myretail.model.ProductDetails;
import org.springframework.stereotype.Service;

@Service
public interface ProductDetailsService {

  ProductDetails getProductDetails(long productId);

  void updateProductDetails(ProductDetails productDetails);
}
