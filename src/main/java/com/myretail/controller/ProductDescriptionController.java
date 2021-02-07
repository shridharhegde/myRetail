package com.myretail.controller;

import com.myretail.model.ProductDetails;
import com.myretail.service.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductDescriptionController {

  @Autowired
  ProductDescriptionService productDescriptionService;

  @GetMapping("/description/{productId}")
  @CrossOrigin("*")
  public ProductDetails getProductDescription(@PathVariable long productId) {
    return productDescriptionService.getProductDescription(productId);
  }
}
