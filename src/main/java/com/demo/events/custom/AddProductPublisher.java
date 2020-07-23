package com.demo.events.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AddProductPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public AddProductPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishAddedProduct(String productId) {
        AddProductEvent addProductEvent = new AddProductEvent(this, productId);
        this.applicationEventPublisher.publishEvent(addProductEvent);
    }
}
