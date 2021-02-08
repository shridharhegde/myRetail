package com.myretail.controller;

import com.myretail.model.ProductDetails;
import com.myretail.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductDetailsController {

  @Autowired
  ProductDetailsService productDetailsService;

  @GetMapping("/{productId}")
  @CrossOrigin("*")
  public ProductDetails getProductDetails(@PathVariable long productId) {
    return productDetailsService.getProductDetails(productId);
  }

  @PutMapping("/{productId}")
  @CrossOrigin("*")
  public void updateProductPriceDetails(@PathVariable long productId,
      @RequestBody ProductDetails productDetails) {
    productDetailsService.updateProductPriceDetails(productDetails, productId);
  }
}
