package com.demo.events.custom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AddProductListener {

    @EventListener(AddProductEvent.class)
    public void onProductAdded(AddProductEvent addProductEvent) {
        //TODO notify the users
        //TODO count the products for the day

        System.out.println(addProductEvent);
    }
}
