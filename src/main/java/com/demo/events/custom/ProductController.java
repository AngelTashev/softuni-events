package com.demo.events.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final AddProductPublisher addProductPublisher;
    private int productCounter = 0;

    @Autowired
    public ProductController(AddProductPublisher addProductPublisher) {
        this.addProductPublisher = addProductPublisher;
    }

    @GetMapping("/add-product")
    public ResponseEntity<String> addProduct() {
        addProductPublisher.publishAddedProduct("Product " + (++productCounter));
        return ResponseEntity.ok().build();
    }
}
