package com.demo.events.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AnnotationBean {

    @PostConstruct
    public void postConstruct() {
        System.out.println("AnnotationBean: Bean constructed!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("AnnotationBean: I'm being destroyed!");
    }
}
