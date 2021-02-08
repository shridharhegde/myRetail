package com.myretail.service;

import com.myretail.model.ProductDetails;
import org.springframework.stereotype.Service;

@Service
public interface ProductDetailsService {

  ProductDetails getProductDetails(long productId);

  void updateProductPriceDetails(ProductDetails productDetails, long productId);
}
