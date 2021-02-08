package com.myretail.controller;

import com.myretail.service.DefaultPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class DefaultPriceDetailsController {

  @Autowired
  DefaultPriceService defaultPriceService;

  @PutMapping("/defaults")
  @CrossOrigin("*")
  public void setDefaultPriceDetails() {
    defaultPriceService.setDefaultPriceDetails();
  }
}
